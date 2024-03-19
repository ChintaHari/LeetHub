class Tweet{
    int time;
    int id;
    Tweet(int id, int time){
        this.id = id;
        this.time = time;
    }
}

class Twitter {
    HashMap<Integer, Set<Integer>> followeeMap;
    HashMap<Integer, List<Tweet>> tweetsMap;
    int timeStamp;

    public Twitter() {
        followeeMap = new HashMap<>();
        tweetsMap = new HashMap<>();
        timeStamp =0;
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetsMap.computeIfAbsent(userId, k -> new ArrayList<>()).add(new Tweet(tweetId, timeStamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<>((a,b) -> b.time - a.time);
        if(tweetsMap.containsKey(userId))
            queue.addAll(tweetsMap.get(userId));
        
        if(followeeMap.containsKey(userId)){
            for(int followeeId : followeeMap.get(userId))
                if(tweetsMap.containsKey(followeeId))
                    queue.addAll(tweetsMap.get(followeeId));
        }
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty() && result.size() < 10)
            result.add(queue.remove().id);
        
        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followeeMap.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followeeMap.containsKey(followerId) && followerId != followeeId)
            followeeMap.get(followerId).remove(followeeId);
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