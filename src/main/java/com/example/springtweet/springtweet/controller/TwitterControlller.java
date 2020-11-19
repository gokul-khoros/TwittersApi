package com.example.springtweet.springtweet.controller;

import org.springframework.web.bind.annotation.*;
import twitter4j.*;

@RestController
@RequestMapping(value = "/api/1.0/twitter")
public class TwitterControlller {

    Twitter twitter = TwitterFactory.getSingleton();

    @GetMapping(value = "/timeline")
    public ResponseList<Status> getTweets() {
        try {
            return twitter.getHomeTimeline();
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping(value = "/tweet")
    private String getTimeLine(@RequestBody String tweetMessage) {
        try {
            twitter.updateStatus(tweetMessage);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        String statement = "Statement Successfully posted : " + tweetMessage;
        return statement;
    }

}
