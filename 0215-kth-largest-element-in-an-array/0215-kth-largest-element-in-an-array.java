class Solution {

    public int findKthLargest(int[] nums, int k) {

        Queue<Integer> heap = new PriorityQueue<>();
        
        for (var i = 0; i < k; i++) {
            heap.offer(nums[i]);
        }

        for (var i = k; i < nums.length; i++) {
            if (nums[i] > heap.peek()) {
                heap.poll();
                heap.offer(nums[i]);
            }
        }

        return heap.peek();
    }
}