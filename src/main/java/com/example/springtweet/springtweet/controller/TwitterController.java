package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import org.springframework.http.ResponseEntity;
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

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterController {

    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping(value = "/timeline")
    public Object getTimeLine() {
        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.getStackTrace();
            return e;
        }
    }

    @PostMapping(value = "/tweet")
    private ResponseEntity postTweet(@RequestParam(value = "file") MultipartFile file, @RequestParam String tweetMessage) throws CustomException, SuccessMessage {
        try {
            InputStream inputStream = file.getInputStream();
            Twitter twitter = new TwitterFactory().getInstance();
            StatusUpdate statusUpdate = new StatusUpdate(tweetMessage);
            statusUpdate.media(tweetMessage, inputStream);
            Status updatesStatus = twitter.updateStatus(statusUpdate);
            String url = "https://twitter.com/" + updatesStatus.getUser().getScreenName() + "/status/" + updatesStatus.getId();
            throw new SuccessMessage(url);
        } catch (TwitterException | IOException e) {
            e.printStackTrace();
            throw new CustomException();
        }
    }

}