class RecentCounter {

    private final Queue<Integer> heap;

    public RecentCounter() {
        this.heap = new LinkedList<>();
    }
    
    public int ping(int t) {

        while (!heap.isEmpty() && heap.peek() < t - 3000) {
            heap.poll();
        }
        
        heap.add(t);

        return heap.size();
    }
}