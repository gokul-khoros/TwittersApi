package com.example.springtweet.springtweet.Services;

import com.example.springtweet.springtweet.Dao.DaoTwitter;
import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import javax.xml.ws.Response;

public class TwitterService {

    DaoTwitter daoTwitter = new DaoTwitter();

    public ResponseList<Status> getTimeLine(Twitter twitter) throws TwitterException {
        return daoTwitter.getTimeLine(twitter);
    }

    public Response postTweet(String tweetMessage, Twitter twitter) throws CustomException {
        return  daoTwitter.postTweet(tweetMessage,twitter);
    }

    public String postImageTweet(MultipartFile file, String tweetMessage, Twitter twitter) throws CustomException {
        return daoTwitter.postImageTweet(file,tweetMessage,twitter);
    }
}
