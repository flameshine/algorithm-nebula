class SmallestInfiniteSet {

    private final Queue<Integer> heap;
    private final Set<Integer> set;

    public SmallestInfiniteSet() {

        this.heap = new PriorityQueue<>();
        this.set = new HashSet<>();

        for (var i = 1; i <= 1000; i++) {
            heap.offer(i);
            set.add(i);
        }
    }
    
    public int popSmallest() {
        var smallest = heap.poll();
        set.remove(smallest);
        return smallest;
    }
    
    public void addBack(int num) {
        
        if (set.contains(num)) {
            return;
        }

        set.add(num);
        heap.offer(num);
    }
}