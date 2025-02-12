class Solution {

    public int findKthLargest(int[] nums, int k) {
        
        Queue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());

        for (var n : nums) {
            heap.offer(n);
        }

        while (k-- > 1) {
            heap.poll();
        }

        return heap.poll();
    }
}