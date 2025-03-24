class Solution {

    public int findKthLargest(int[] nums, int k) {
        
        Queue<Integer> heap = new PriorityQueue<>();

        for (var n : nums) {

            heap.offer(n);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        return heap.peek();
    }
}