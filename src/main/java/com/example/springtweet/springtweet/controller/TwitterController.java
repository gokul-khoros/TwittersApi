package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.Services.TwitterService;
import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.model.TwitterDetails;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterController {

    static Logger logger = Logger.getLogger(TwitterController.class.getName());


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
        logger.trace("Configuring connection");
        return twitter;
    }


    TwitterService twitterService = new TwitterService();

    @GetMapping(value = "/timeline")
    public List<TwitterDetails> getTimeLine() throws TwitterException {
        Twitter twitter = getTwitterInstance();
        return twitterService.getTimeLine(twitter);
    }

    @GetMapping(value = "/timeline/filter")
    public List<TwitterDetails> getTimeLineWithFilter() throws TwitterException {
        Twitter twitter = getTwitterInstance();
        return twitterService.getTwitterLineWithFilter(twitter);
    }

    @PostMapping(value = "/tweet")
    public Response postTweet(@RequestParam String tweetMessage) throws CustomException {
        Twitter twitter = getTwitterInstance();
        return twitterService.postTweet(tweetMessage, twitter);
    }

    //post method for uploading image and tweet
    @PostMapping(value = "/tweetImage")
    public String postImageTweet(@RequestParam(value = "file") MultipartFile file, @RequestParam String tweetMessage) throws CustomException {
        Twitter twitter = getTwitterInstance();
        return twitterService.postImageTweet(file, tweetMessage, twitter);
    }

}