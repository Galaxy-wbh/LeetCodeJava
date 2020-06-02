package M_LC0335;

import java.lang.reflect.Array;
import java.util.*;

class Twitter {

    private ArrayList<Map> tweets;

    private Map<Integer, ArrayList> followRelationship;

    /** Initialize your data structure here. */
    public Twitter() {
        //推文
        tweets = new ArrayList<>();
        //关注列表
        followRelationship = new HashMap<>();

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Map<Integer, Integer> map = new HashMap<>();
        if(userId < 0)
            return;
        if(followRelationship.get(userId) == null) {//第一次发推时把自己也放入关注列表
            ArrayList<Integer> list = new ArrayList<>();
            list.add(userId);
            followRelationship.put(userId, list);
        }
        map.put(userId, tweetId);
        tweets.add(map);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        ArrayList<Integer> list = followRelationship.get(userId);
        if(list == null)//这个用户不存在
            return res;
        int count = 0;
        for (int i=tweets.size()-1;i>=0;i--){
            Map<Integer, Integer> map = tweets.get(i);
            if (list.containsAll(map.keySet())){
                for(Integer id:map.values())
                    res.add(id);
                count++;
            }
            if(count == 10)
                break;
        }
        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //followerId没意义
        if(followerId < 0 || followeeId == followerId)
            return;
        ArrayList<Integer> list = followRelationship.get(followerId);
        if(list == null){//
            list = new ArrayList<Integer>();
            list.add(followerId);
        }
        if(list.contains(followeeId)){//已经关注过了
            System.out.println("already followed.");
            return;
        }
        list.add(followeeId);
        followRelationship.put(followerId, list);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        //followeeId没意义
        if(followerId < 0 || followeeId == followerId)
            return;
        ArrayList<Integer> list = followRelationship.get(followerId);
        if(list == null){//这个用户没有关注过别人
            System.out.println("This user has not followed anyone.");
            return;
        }
        if(list.contains(followeeId)){//关注了这个用户
            list.remove(list.indexOf(followeeId));//移除
        }else{//没有关注过这个用户
            System.out.println("This user has not follow followeeId");
            return;
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
