package Design_Twitter;
import java.util.*;

/*
 * Design a simplified version of Twitter where users can post tweets, 
 * follow/unfollow another user, and is able to see the 10 most recent
 *  tweets in the user's news feed.
 */
public class Twitter {
    int timestamp;
    HashMap<Integer,List<int[]>> lastTweets; // int[] is tweet id and "timestamp"
    HashMap<Integer, Set<Integer>> follows;
    // que for news feed, only keep 10 recent posts
    
    public Twitter() {
        timestamp = 0;
        lastTweets = new HashMap<>();
        follows = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        follows.putIfAbsent(userId, new HashSet<Integer>());
        follows.get(userId).add(userId);

        lastTweets.putIfAbsent(userId, new ArrayList<>());
        lastTweets.get(userId).add(0, new int[] {tweetId,timestamp++});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!follows.containsKey(userId)) return new ArrayList<>();
        List<Integer> tweets = new ArrayList<>();
        PriorityQueue<int[]> que = new PriorityQueue<>(10,(x,y) -> Integer.compare(y[1], x[1]));
        follows.get(userId).stream()
        .filter(follower -> lastTweets.containsKey(follower))
        .forEach(follower -> lastTweets.get(follower).forEach(que::add));

        while (!que.isEmpty() && tweets.size() < 10) 
            tweets.add(que.poll()[0]);
        return tweets;
    }
    
    public void follow(int followerId, int followeeId) {
        follows.putIfAbsent(followerId, new HashSet<Integer>());
        follows.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followeeId)) 
            follows.get(followerId).remove(followeeId);
    }
}