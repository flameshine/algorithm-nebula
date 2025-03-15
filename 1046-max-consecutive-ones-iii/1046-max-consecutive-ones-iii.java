class Solution {
    
    public int longestOnes(int[] nums, int k) {
        
        var left = 0;
        var zeroes = 0;
        var result = 0;

        for (var right = 0; right < nums.length; right++) {

            if (nums[right] == 0) {
                ++zeroes;
            }

            if (zeroes > k) {
                if (nums[left++] == 0) {
                    --zeroes;
                }
            }

            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}