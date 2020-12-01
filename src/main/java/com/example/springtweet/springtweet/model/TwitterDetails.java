package com.example.springtweet.springtweet.model;

import java.util.Date;

public class TwitterDetails {

    String message;
    String username;
    String screenName;
    String profileImageUrl;
    Date createdAt;

    public TwitterDetails() {
    }

    public TwitterDetails(String text, Date createdAt, String name, String profileImageURL, String screenName) {
        this.message = text;
        this.username = name;
        this.screenName = screenName;
        this.profileImageUrl = profileImageURL;
        this.createdAt = createdAt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getScreenName() {
        return screenName;
    }

    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    public String getProfileImageUrl() {
        return profileImageUrl;
    }

    public void setProfileImageUrl(String profileImageUrl) {
        this.profileImageUrl = profileImageUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TwitterDetails{" +
                "message='" + message + '\'' +
                ", username='" + username + '\'' +
                ", screenName='" + screenName + '\'' +
                ", profileImageUrl='" + profileImageUrl + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
