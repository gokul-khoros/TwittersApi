package com.example.springtweet.springtweet.controller;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.TwitterException;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
 public class TwitterControllerTest {

    @Mock
     TwitterController twitterController;

    @Test
    public void getTimeLineTest() throws TwitterException {
        when(twitterController.getTimeLine()).thenReturn(Collections.singletonList("Tweet from Timeline"));
        List<String> getTimeLineMsg = twitterController.getTimeLine();
        assertEquals(Collections.singletonList("Tweet from Timeline"),getTimeLineMsg);
    }

    @Test
    public void postTweetTest() throws CustomException, SuccessMessage {
        MultipartFile file = null;
        String tweet = "yoyo";
        Mockito.when(twitterController.postTweet(any(),any())).thenReturn(tweet);
        String json = twitterController.postTweet(file,tweet);
        String expect = "yoyo";
        assertEquals(expect,json);
    }



}