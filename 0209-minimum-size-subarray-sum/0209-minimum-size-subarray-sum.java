class Solution {

    public int minSubArrayLen(int target, int[] nums) {
        
        var left = 0;
        var sum = 0;
        var result = Integer.MAX_VALUE;

        for (var right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}