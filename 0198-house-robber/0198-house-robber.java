class Solution {

    public int rob(int[] nums) {
        
        var n = nums.length;

        if (n == 1) {
            return nums[0];
        }

        var dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (var i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        return dp[n - 1];
    }
}