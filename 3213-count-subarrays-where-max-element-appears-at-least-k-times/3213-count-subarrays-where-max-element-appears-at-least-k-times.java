class Solution {

    public long countSubarrays(int[] nums, int k) {
        
        var max = Long.MIN_VALUE;

        for (var n : nums) {
            max = Math.max(max, n);
        }

        var count = 0L;
        var left = 0;
        var right = 0;

        while (right < nums.length) {

            k -= nums[right++] == max ? 1 : 0;

            while (k == 0) {
                k += nums[left++] == max ? 1 : 0;
            }

            count += left;
        }

        return count;
    }
}