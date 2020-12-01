package com.example.springtweet.springtweet.Dao;

import com.example.springtweet.springtweet.exceptionHandler.CustomException;
import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
import com.example.springtweet.springtweet.model.TwitterDetails;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import twitter4j.Twitter;
import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.StatusUpdate;

import javax.xml.ws.Response;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Component
public class DaoTwitter {

    Logger logger = Logger.getLogger(DaoTwitter.class.getName());

    public List<TwitterDetails> getTimeLine(Twitter twitter) throws TwitterException {
        try {
            logger.trace("gethomefeed");
            List<TwitterDetails> getTimeline = new ArrayList<>();
            List<Status> getHomeTimeLine = twitter.getHomeTimeline();
            for (Status sa : getHomeTimeLine) {
                TwitterDetails twitterInformation = new TwitterDetails();
                twitterInformation.setMessage(sa.getText());
                twitterInformation.setCreatedAt(sa.getCreatedAt());
                twitterInformation.setUsername(sa.getUser().getName());
                twitterInformation.setProfileImageUrl(sa.getUser().getProfileImageURL());
                twitterInformation.setScreenName(sa.getUser().getScreenName());
                getTimeline.add(twitterInformation);
            }
            return getTimeline;
        } catch (TwitterException e) {
            logger.error(e);
            throw e;
        }
    }

    public Response postTweet(String tweetMessage, Twitter twitter) throws CustomException {
        try {
            Status status = twitter.updateStatus(tweetMessage);
            String url = "https://twitter.com/" + status.getUser().getScreenName() + "/status/" + status.getId();
            throw new SuccessMessage(url);
        } catch (TwitterException | SuccessMessage e) {
            logger.error(e);
            e.printStackTrace();
            throw new CustomException();
        }
    }

    public String postImageTweet(MultipartFile file, String tweetMessage, Twitter twitter) throws CustomException {
        try {
            InputStream inputStream = file.getInputStream();
            StatusUpdate statusUpdate = new StatusUpdate(tweetMessage);
            statusUpdate.media(" ", inputStream);
            Status updatesStatus = twitter.updateStatus(statusUpdate);
            String url = "https://twitter.com/" + updatesStatus.getUser().getScreenName() + "/status/" + updatesStatus.getId();
            throw new SuccessMessage(url);
        } catch (TwitterException | IOException | SuccessMessage e) {
            logger.error(e);
            e.printStackTrace();
            throw new CustomException();
        }
    }

    public List<TwitterDetails> getTwitterLineWithFilter(Twitter twitter) throws TwitterException {
        try {
            logger.trace("gethomefeed");
            List<TwitterDetails> getTimeline = new ArrayList<>();
            List<Status> getHomeTimeLine = twitter.getHomeTimeline();
            for (Status sa : getHomeTimeLine) {
                TwitterDetails twitterInformation = new TwitterDetails(sa.getText(),sa.getUser().getName(),sa.getUser().getProfileImageURL(),sa.getUser().getScreenName(),sa.getCreatedAt());
                getTimeline.add(twitterInformation);
            }
            return getTimeline;
        } catch (TwitterException e) {
            logger.error(e);
            throw e;
        }
    }
}
