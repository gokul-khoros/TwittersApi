
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Paging;

import java.util.List;

public class TimeLine {
    public static void getUserTimeLine(String twitterId, int pageNum, int pageLimit) {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging page = new Paging(pageNum, pageLimit); //page number, number per page
        List<Status> statuses = null;
        try {
            statuses = twitter.getUserTimeline(twitterId, page);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        statuses.forEach(System.out::println);
    }

    public static void getHomeTimeLine(int pagenum, int pageLimit) {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging page = new Paging(pagenum, pageLimit);
        List<Status> statuses = null;
        try {
            statuses = twitter.getHomeTimeline(page);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        statuses.forEach(System.out::println);
    }
}
