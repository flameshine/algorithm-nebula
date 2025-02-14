class MedianFinder {

    private final Queue<Integer> lowerHalf;
    private final Queue<Integer> upperHalf;

    public MedianFinder() {
        this.lowerHalf = new PriorityQueue<>(Collections.reverseOrder());
        this.upperHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        
        if (lowerHalf.isEmpty() || num <= lowerHalf.peek()) {
            lowerHalf.add(num);
        } else {
            upperHalf.add(num);
        }

        if (upperHalf.size() > lowerHalf.size()) {
            lowerHalf.add(upperHalf.poll());
        } else if (lowerHalf.size() > upperHalf.size() + 1) {
            upperHalf.add(lowerHalf.poll());
        }
    }
    
    public double findMedian() {
        if (lowerHalf.size() == upperHalf.size()) {
            return (double) (lowerHalf.peek() + upperHalf.peek()) / 2;
        } else {
            return (double) lowerHalf.peek();
        }
    }
}