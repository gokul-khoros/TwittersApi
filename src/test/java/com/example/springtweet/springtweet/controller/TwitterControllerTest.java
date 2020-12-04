//package com.example.springtweet.springtweet.controller;
//
//import com.example.springtweet.springtweet.exceptionHandler.CustomException;
//import com.example.springtweet.springtweet.exceptionHandler.SuccessMessage;
//import com.example.springtweet.springtweet.model.TwitterDetails;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import twitter4j.*;
//
//import javax.xml.ws.Response;
//import java.util.Date;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class TwitterControllerTest {
//
//    @Mock
//    Twitter twitter;
//
//    @InjectMocks
//    TwitterController twitterController;
//
//    @Test
//    public void getTimeLineTest() throws TwitterException {
//        Status response = (Status) twitter.getHomeTimeline();
//        when(twitter.getHomeTimeline()).thenReturn((ResponseList<Status>) response);
//        List<TwitterDetails> getTimeLineMsg = twitterController.getTimeLine();
//        assertEquals(response, getTimeLineMsg);
//    }
//
//    @Test(expected = SuccessMessage.class)
//    public void postTweetTest() throws CustomException, SuccessMessage, TwitterException {
//        Status status1 = new Status() {
//            @Override
//            public Date getCreatedAt() {
//                return null;
//            }
//
//            @Override
//            public long getId() {
//                return 0;
//            }
//
//            @Override
//            public String getText() {
//                return null;
//            }
//
//            @Override
//            public int getDisplayTextRangeStart() {
//                return 0;
//            }
//
//            @Override
//            public int getDisplayTextRangeEnd() {
//                return 0;
//            }
//
//            @Override
//            public String getSource() {
//                return null;
//            }
//
//            @Override
//            public boolean isTruncated() {
//                return false;
//            }
//
//            @Override
//            public long getInReplyToStatusId() {
//                return 0;
//            }
//
//            @Override
//            public long getInReplyToUserId() {
//                return 0;
//            }
//
//            @Override
//            public String getInReplyToScreenName() {
//                return null;
//            }
//
//            @Override
//            public GeoLocation getGeoLocation() {
//                return null;
//            }
//
//            @Override
//            public Place getPlace() {
//                return null;
//            }
//
//            @Override
//            public boolean isFavorited() {
//                return false;
//            }
//
//            @Override
//            public boolean isRetweeted() {
//                return false;
//            }
//
//            @Override
//            public int getFavoriteCount() {
//                return 0;
//            }
//
//            @Override
//            public User getUser() {
//                User user;
//                return user = new User() {
//                    @Override
//                    public long getId() {
//                        return 0;
//                    }
//
//                    @Override
//                    public String getName() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getEmail() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getScreenName() {
//                        return "happy";
//                    }
//
//                    @Override
//                    public String getLocation() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getDescription() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isContributorsEnabled() {
//                        return false;
//                    }
//
//                    @Override
//                    public String getProfileImageURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getBiggerProfileImageURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getMiniProfileImageURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getOriginalProfileImageURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileImageURLHttps() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getBiggerProfileImageURLHttps() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getMiniProfileImageURLHttps() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getOriginalProfileImageURLHttps() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isDefaultProfileImage() {
//                        return false;
//                    }
//
//                    @Override
//                    public String getURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isProtected() {
//                        return false;
//                    }
//
//                    @Override
//                    public int getFollowersCount() {
//                        return 0;
//                    }
//
//                    @Override
//                    public Status getStatus() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBackgroundColor() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileTextColor() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileLinkColor() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileSidebarFillColor() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileSidebarBorderColor() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isProfileUseBackgroundImage() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isDefaultProfile() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isShowAllInlineMedia() {
//                        return false;
//                    }
//
//                    @Override
//                    public int getFriendsCount() {
//                        return 0;
//                    }
//
//                    @Override
//                    public Date getCreatedAt() {
//                        return null;
//                    }
//
//                    @Override
//                    public int getFavouritesCount() {
//                        return 0;
//                    }
//
//                    @Override
//                    public int getUtcOffset() {
//                        return 0;
//                    }
//
//                    @Override
//                    public String getTimeZone() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBackgroundImageURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBackgroundImageUrlHttps() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerRetinaURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerIPadURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerIPadRetinaURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerMobileURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public String getProfileBannerMobileRetinaURL() {
//                        return null;
//                    }
//
//                    @Override
//                    public boolean isProfileBackgroundTiled() {
//                        return false;
//                    }
//
//                    @Override
//                    public String getLang() {
//                        return null;
//                    }
//
//                    @Override
//                    public int getStatusesCount() {
//                        return 0;
//                    }
//
//                    @Override
//                    public boolean isGeoEnabled() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isVerified() {
//                        return false;
//                    }
//
//                    @Override
//                    public boolean isTranslator() {
//                        return false;
//                    }
//
//                    @Override
//                    public int getListedCount() {
//                        return 0;
//                    }
//
//                    @Override
//                    public boolean isFollowRequestSent() {
//                        return false;
//                    }
//
//                    @Override
//                    public URLEntity[] getDescriptionURLEntities() {
//                        return new URLEntity[0];
//                    }
//
//                    @Override
//                    public URLEntity getURLEntity() {
//                        return null;
//                    }
//
//                    @Override
//                    public String[] getWithheldInCountries() {
//                        return new String[0];
//                    }
//
//                    @Override
//                    public int compareTo(User o) {
//                        return 0;
//                    }
//
//                    @Override
//                    public RateLimitStatus getRateLimitStatus() {
//                        return null;
//                    }
//
//                    @Override
//                    public int getAccessLevel() {
//                        return 0;
//                    }
//                };
//            }
//
//            @Override
//            public boolean isRetweet() {
//                return false;
//            }
//
//            @Override
//            public Status getRetweetedStatus() {
//                return null;
//            }
//
//            @Override
//            public long[] getContributors() {
//                return new long[0];
//            }
//
//            @Override
//            public int getRetweetCount() {
//                return 0;
//            }
//
//            @Override
//            public boolean isRetweetedByMe() {
//                return false;
//            }
//
//            @Override
//            public long getCurrentUserRetweetId() {
//                return 0;
//            }
//
//            @Override
//            public boolean isPossiblySensitive() {
//                return false;
//            }
//
//            @Override
//            public String getLang() {
//                return null;
//            }
//
//            @Override
//            public Scopes getScopes() {
//                return null;
//            }
//
//            @Override
//            public String[] getWithheldInCountries() {
//                return new String[0];
//            }
//
//            @Override
//            public long getQuotedStatusId() {
//                return 0;
//            }
//
//            @Override
//            public Status getQuotedStatus() {
//                return null;
//            }
//
//            @Override
//            public int compareTo(Status o) {
//                return 0;
//            }
//
//            @Override
//            public UserMentionEntity[] getUserMentionEntities() {
//                return new UserMentionEntity[0];
//            }
//
//            @Override
//            public URLEntity[] getURLEntities() {
//                return new URLEntity[0];
//            }
//
//            @Override
//            public HashtagEntity[] getHashtagEntities() {
//                return new HashtagEntity[0];
//            }
//
//            @Override
//            public MediaEntity[] getMediaEntities() {
//                return new MediaEntity[0];
//            }
//
//            @Override
//            public SymbolEntity[] getSymbolEntities() {
//                return new SymbolEntity[0];
//            }
//
//            @Override
//            public RateLimitStatus getRateLimitStatus() {
//                return null;
//            }
//
//            @Override
//            public int getAccessLevel() {
//                return 0;
//            }
//        };
//        Status status = mock(Status.class);
//        when(twitter.updateStatus(anyString())).thenReturn(status);
////        Response responseList = twitterController.postTweet("hello");
//    }
//
//}