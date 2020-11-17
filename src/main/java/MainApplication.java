import twitter4j.*;

public class MainApplication {
    public static void main(String[] args) throws TwitterException {
        createTweet("My First tweet");
        RetriveTimeline.getTimeLine();
    }

    public static void createTweet(String myTweet) throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Status status = twitter.updateStatus(myTweet);
        System.out.println("Successfully updated the status : " + myTweet);
    }

}