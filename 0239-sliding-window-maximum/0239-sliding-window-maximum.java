class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        
        var pointer = 0;
        var result = new int[nums.length - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (var i = 0; i < nums.length; i++) {

            if (!deque.isEmpty() && deque.peek() == i - k) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                result[pointer++] = nums[deque.peek()];
            }
        }

        return result;
    }
}