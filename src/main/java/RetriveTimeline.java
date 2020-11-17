import twitter4j.*;

import java.util.List;

public class RetriveTimeline {


    public static void getTimeLine() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Paging page = new Paging (1, 10); //page number, number per page
        List<Status> statuses = twitter.getUserTimeline("SonuSood",page);
        statuses.forEach(System.out::println);
    }

}
