package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterController {

    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping(value = "/timeline")
    public ResponseList<Status> getTimeLine() {
        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/tweet")
    private ResponseEntity postTweet(@RequestBody String tweetMessage) throws MyException, CustomException {

        try {
            Twitter twitter = new TwitterFactory().getInstance();
            StatusUpdate status = new StatusUpdate(tweetMessage);
            status.setMedia(new File("/Users/gokul.ravichandran/Desktop/sc.png"));
            Status updatesStatus = twitter.updateStatus(status);
            String url ;
            url = updatesStatus.getText();
            throw new MyException(url);
        } catch (TwitterException e) {
            e.printStackTrace();
            throw new CustomException();
        }
    }

}


