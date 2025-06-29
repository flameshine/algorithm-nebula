class Solution {

    public int coinChange(int[] coins, int amount) {

        var dp = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (var i = 1; i <= amount; i++) {
            for (var j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0 && dp[i - coins[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}