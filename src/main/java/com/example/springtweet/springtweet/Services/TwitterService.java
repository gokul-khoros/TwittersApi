package com.example.springtweet.springtweet.Services;

import com.example.springtweet.springtweet.Dao.DaoTwitter;
import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.model.TwitterDetails;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Twitter;
import twitter4j.TwitterException;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TwitterService {

    DaoTwitter daoTwitter = new DaoTwitter();

    public List<TwitterDetails> getTimeLine(Twitter twitter) throws TwitterException {
        return daoTwitter.getTimeLine(twitter);
    }

    public Response postTweet(String tweetMessage, Twitter twitter) throws CustomException {
        return daoTwitter.postTweet(tweetMessage, twitter);
    }

    public String postImageTweet(MultipartFile file, String tweetMessage, Twitter twitter) throws CustomException {
        return daoTwitter.postImageTweet(file, tweetMessage, twitter);
    }

    public List<TwitterDetails> getTwitterLineWithFilter(Twitter twitter) throws TwitterException {
        List<TwitterDetails> twitterDetails = daoTwitter.getTwitterLineWithFilter(twitter);
//        return daoTwitter.getTwitterLineWithFilter(twitter);
//        sort and collect method
        return twitterDetails.stream().sorted(Comparator.comparing(TwitterDetails::getUsername)).collect(Collectors.toList());
//        filter and for each method
//        twitterDetails.stream().filter(twitterDetails1 -> twitterDetails.contains("Sonu")).forEach(System.out::println);
//        limit method
//        return twitterDetails.stream().filter(s -> s.getUsername().contains("e")).limit(10).collect(Collectors.toList());
    }
}
