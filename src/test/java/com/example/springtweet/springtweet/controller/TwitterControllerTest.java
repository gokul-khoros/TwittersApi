package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import twitter4j.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TwitterControllerTest {

    @Mock
    Twitter twitter;

    @InjectMocks
    TwitterController twitterController;

    @Test
    public void getTimeLineTest() throws TwitterException {
        Status response = (Status) twitter.getHomeTimeline();
        when(twitter.getHomeTimeline()).thenReturn((ResponseList<Status>) response);
        ResponseList<Status> getTimeLineMsg = twitterController.getTimeLine();
        assertEquals(response, getTimeLineMsg);
    }

    @Test
    public void postTweetTest() throws CustomException, SuccessMessage, TwitterException {
        Status status = null;
        when(twitter.updateStatus(anyString())).thenReturn(status);
        Status twitterStatus = twitterController.postTweet("hello");
        assertEquals(twitterStatus, status);
    }


}