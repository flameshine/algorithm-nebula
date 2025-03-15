class Solution {
    
    public int longestOnes(int[] nums, int k) {
        
        var left = 0;
        var right = 0;
        var zeroes = 0;

        while (right < nums.length) {

            if (nums[right++] == 0) {
                ++zeroes;
            }

            if (zeroes > k) {
                if (nums[left++] == 0) {
                    --zeroes;
                }
            }
        }

        return right - left;
    }
}