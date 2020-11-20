package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.*;

import java.io.*;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterController {

    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping(value = "/timeline")
    public ResponseList<Status> getTimeLine() {
        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.getStackTrace();
            return (ResponseList<Status>) e;
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