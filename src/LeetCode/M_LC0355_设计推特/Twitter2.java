package LeetCode.M_LC0355_设计推特;

import java.util.*;

public class Twitter2 {

    /**
     * 用户id和推文(单链表)的对应关系
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户id和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前+1
     */
    private static int timestamp = 0;

    private static PriorityQueue<Tweet> maxHeap;

    public Twitter2(){
        followings = new HashMap<>();
        twitter = new HashMap<>();
        maxHeap = new PriorityQueue<>((o1, o2)-> -o1.timestamp + o2.timestamp);
    }

    public void postTweet(int userId, int tweetId){
        timestamp++;
        if(twitter.containsKey(userId)){
            Tweet oldHead = twitter.get(userId);
            Tweet newHead = new Tweet(tweetId, timestamp);
            newHead.next = oldHead;
            twitter.put(userId, newHead);
        }else{
            twitter.put(userId, new Tweet(tweetId, timestamp));
        }
    }

    public List<Integer> getNewsFeed(int userId){
        maxHeap.clear();
        if(twitter.containsKey(userId)){
            maxHeap.offer(twitter.get(userId));
        }
        Set<Integer> followingList = followings.get(userId);
        if(followingList != null && followingList.size()>0){
            for(Integer followingId:followingList){
                Tweet tweet = twitter.get(followingId);
                if(tweet != null)
                    maxHeap.offer(tweet);
            }
        }
        List<Integer> res = new ArrayList<>(10);
        int count = 0;
        while(!maxHeap.isEmpty() && count < 10){
            Tweet head = maxHeap.poll();
            res.add(head.id);
            if(head.next != null){
                maxHeap.offer(head.next);
            }
            count ++;
        }
        return res;
    }


    public void follow(int followerId, int followeeId){
        if(followeeId == followerId)//不能关注自己
            return;

        Set<Integer> followingList = followings.get(followerId);
        if(followingList == null){
            Set<Integer> init = new HashSet<>();
            init.add(followeeId);
            followings.put(followerId, init);
        }else{
            if(followingList.contains(followeeId)){
                return;
            }
            followingList.add(followeeId);
        }
    }

    public void unfollow(int followerId, int followeeId){
        if(followerId == followeeId)
            return;
        Set<Integer> folloingList = followings.get(followerId);
        if(folloingList == null)
            return;
        folloingList.remove(followeeId);
    }

    private class Tweet{
        /**
         * 推文id
         */
        private int id;

        /**
         * 发推时间戳
         */

        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }

    }
}
