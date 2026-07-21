class Twitter {
    private int time = 0;
    private Map<Integer,Set<Integer>> followmap = new HashMap<>();
    private Map<Integer,List<int[]>> tweetmap = new HashMap<>();
    public Twitter() {
        
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetmap.putIfAbsent(userId,new ArrayList<>());
        tweetmap.get(userId).add(new int[] {time++,tweetId});
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        followmap.putIfAbsent(userId,new HashSet<>());
        followmap.get(userId).add(userId);
        for(int f:followmap.get(userId)){
            if(!tweetmap.containsKey(f)) continue;
            List<int[]> t = tweetmap.get(f);
            for(int tweet[]:t) pq.offer(tweet);
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty() && ans.size()<10) ans.add(pq.poll()[1]);
        return ans;
    }
    
    public void follow(int followerId, int followeeId) {
        followmap.putIfAbsent(followerId,new HashSet<>());
        followmap.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followmap.containsKey(followerId)) followmap.get(followerId).remove(followeeId);
    }
}
