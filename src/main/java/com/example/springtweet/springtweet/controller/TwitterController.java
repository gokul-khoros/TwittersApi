package com.example.springtweet.springtweet.controller;


import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.StatusUpdate;
import twitter4j.ResponseList;
import twitter4j.conf.ConfigurationBuilder;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterController {


    @Value("${demo.consumerKey}")
    String consumerKey;
    @Value("${demo.consumerSecret}")
    String consumerSecret;
    @Value("${demo.accessToken}")
    String accessToken;
    @Value("${demo.accessTokenSecret}")
    String accessTokenSecret;


    public Twitter getTwitterInstance() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(consumerKey)
                .setOAuthConsumerSecret(consumerSecret)
                .setOAuthAccessToken(accessToken)
                .setOAuthAccessTokenSecret(accessTokenSecret);
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        return twitter;
    }


    @GetMapping(value = "/timeline")
    public ResponseList<Status> getTimeLine() throws TwitterException {
        try {
            Twitter twitter = getTwitterInstance();
            twitter = getTwitterInstance();
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            throw e;
        }
    }

    @PostMapping(value = "/tweet")
    public Response postTweet(@RequestParam String tweetMessage) throws CustomException, SuccessMessage {
        try {
            Twitter twitter = getTwitterInstance();
            Status status = twitter.updateStatus(tweetMessage);
            String url = "https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId();
            throw new SuccessMessage(url);
        } catch (TwitterException e) {
            e.printStackTrace();
            throw new CustomException();
        }
    }

    //post method for uploading image and tweet
    @PostMapping(value = "/tweetImage")
    public String postTweet(@RequestParam(value = "file") MultipartFile file, @RequestParam String tweetMessage) throws CustomException, SuccessMessage {
        try {
            InputStream inputStream = file.getInputStream();
            Twitter twitter = new TwitterFactory().getInstance();
            StatusUpdate statusUpdate = new StatusUpdate(tweetMessage);
            statusUpdate.media(" ", inputStream);
            Status updatesStatus = twitter.updateStatus(statusUpdate);
            String url = "https://twitter.com/" + updatesStatus.getUser().getScreenName() + "/status/" + updatesStatus.getId();
            throw new SuccessMessage(url);
        } catch (TwitterException | IOException e) {
            e.printStackTrace();
            throw new CustomException();
        }
    }


}