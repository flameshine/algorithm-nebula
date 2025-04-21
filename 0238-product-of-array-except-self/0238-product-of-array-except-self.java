class Solution {

    public int[] productExceptSelf(int[] nums) {
        
        var prefix = new int[nums.length];

        prefix[0] = 1;

        for (var i = 1; i < nums.length; i++) {
            prefix[i] = nums[i - 1] * prefix[i - 1];
        }

        var suffix = new int[nums.length];

        suffix[nums.length - 1] = 1;

        for (var i = nums.length - 2; i >= 0; i--) {
            suffix[i] = nums[i + 1] * suffix[i + 1];
        }

        var result = new int[nums.length];

        for (var i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}