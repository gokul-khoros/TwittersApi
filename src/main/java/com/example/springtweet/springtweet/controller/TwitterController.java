package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.MyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import twitter4j.*;

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
    @ResponseStatus(HttpStatus.OK)
    private ResponseEntity postTweet(@RequestBody String tweetMessage) throws MyException, CustomException {
        try {
            twitter.updateStatus(tweetMessage);
        } catch (TwitterException e) {
            e.printStackTrace();
            throw new CustomException();
        }
        throw new MyException();
    }
}


