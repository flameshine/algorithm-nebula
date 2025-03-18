class RecentCounter {

    private final Queue<Integer> queue;

    public RecentCounter() {
        this.queue = new LinkedList<>();
    }
    
    public int ping(int t) {

        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }
        
        queue.add(t);

        return queue.size();
    }
}