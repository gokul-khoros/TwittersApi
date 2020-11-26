package com.example.springtweet.springtweet;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SpringTweetApplication {

    static {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.setProperty("current.date", dateFormat.format(new Date()));
    }

    static Logger logger = Logger.getLogger(SpringTweetApplication.class.getName());

    public static void main(String[] args) {
        logger.info("APP started");
        SpringApplication.run(SpringTweetApplication.class, args);
        logger.warn("stopped");
    }

}
