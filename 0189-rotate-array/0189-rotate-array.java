class Solution {

    public void rotate(int[] nums, int k) {

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            var tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}