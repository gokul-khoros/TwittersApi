package com.example.springtweet.springtweet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class TwitterDetails {

    String message;
    String username;
    String profileImageUrl;
    String screenName;
    Date createdAt;

}
