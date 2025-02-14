class Twitter {

    private static int time = 0;

    private final Map<Integer, User> usersById;

    public Twitter() {
        this.usersById = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        
        if (!usersById.containsKey(userId)) {
            var user = new User(userId);
            usersById.put(userId, user);
        }

        usersById.get(userId).post(tweetId);
    }
    
    public List<Integer> getNewsFeed(int userId) {

        if (!usersById.containsKey(userId)) {
            return List.of();
        }
        
        List<Integer> result = new ArrayList<>();
        Set<User> following = usersById.get(userId).following;
        Queue<Tweet> queue = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

        for (var user : following) {
            if (user.latest != null) {
                queue.add(user.latest);
            }
        }

        var n = 0;

        while (!queue.isEmpty() && n++ < 10) {

            var tweet = queue.poll();

            result.add(tweet.id);

            if (tweet.next != null) {
                queue.add(tweet.next);
            }
        }

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        
        if (!usersById.containsKey(followerId)) {
            var user = new User(followerId);
            usersById.put(followerId, user);
        }

        if (!usersById.containsKey(followeeId)) {
            var user = new User(followeeId);
            usersById.put(followeeId, user);
        }

        var followee = usersById.get(followeeId);

        usersById.get(followerId).follow(followee);
    }
    
    public void unfollow(int followerId, int followeeId) {
        
        if (!usersById.containsKey(followerId) || followerId == followeeId) {
            return;
        }

        var followee = usersById.get(followeeId);

        usersById.get(followerId).unfollow(followee);
    }

    private static class Tweet {

        private int id;
        private int timestamp;
        private Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.timestamp = time++;
            this.next = null;
        }
    }

    private static class User {

        private int id;
        private Set<User> following;
        private Tweet latest;

        public User(int id) {
            this.id = id;
            this.following = new HashSet<>();
            this.latest = null;
            follow(this);
        }

        public void follow(User user) {
            following.add(user);
        }

        public void unfollow(User user) {
            following.remove(user);
        }

        public void post(int id) {
            var tweet = new Tweet(id);
            tweet.next = latest;
            latest = tweet;
        }
    }
}