class RecentCounter {

    private static final int RANGE = 3000;

    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        
        queue.add(t);

        while (queue.peek() < t - RANGE) {
            queue.poll();
        }

        return queue.size();
    }
}