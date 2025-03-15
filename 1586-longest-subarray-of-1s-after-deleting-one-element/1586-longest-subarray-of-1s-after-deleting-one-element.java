class Solution {

    public int longestSubarray(int[] nums) {
        
        var left = 0;
        var zeroes = 0;
        var result = 0;

        for (var right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                ++zeroes;
            }

            while (zeroes > 1) {
                if (nums[left++] == 0) {
                    --zeroes;
                }
            }

            result = Math.max(result, right - left);
        }

        return result;
    }
}