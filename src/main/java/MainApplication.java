
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) {
        Scanner scanTweet = new Scanner(System.in);
        String myTweet;
        System.out.println("Enter the tweet to be posted");
        myTweet = scanTweet.nextLine();
        createTweet(myTweet);

        //getting specific user user time line
        Scanner scanTwitterId = new Scanner(System.in);
        System.out.println("\nEnter the specific user id, page number and number of pages to be displayed");
        String twitterId = scanTwitterId.nextLine();
        int pagenum = scanTwitterId.nextInt();
        int pageLimit = scanTwitterId.nextInt();
        TimeLine.getUserTimeLine(twitterId, pagenum, pageLimit);

        //getting home time line
        Scanner scanHome = new Scanner(System.in);
        System.out.println("\nEnter the page number and number of pages to be displayed");
        int homePagenum = scanHome.nextInt();
        int homePageLimit = scanHome.nextInt();
        TimeLine.getHomeTimeLine(homePagenum, homePageLimit);
    }

    public static void createTweet(String myTweet) {
        Twitter twitter = TwitterFactory.getSingleton();
        try {
            Status status = twitter.updateStatus(myTweet);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully updated the status : " + myTweet);
    }
}