class KthLargest {

    private final Queue<Integer> heap;
    private final int k;

    public KthLargest(int k, int[] nums) {

        this.heap = new PriorityQueue<>();
        this.k = k;

        for (var n : nums) {
            add(n);
        }
    }
    
    public int add(int val) {
        
        heap.offer(val);

        if (heap.size() > k) {
            heap.poll();
        }

        return heap.peek();
    }
}