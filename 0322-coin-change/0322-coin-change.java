class Solution {

    public int coinChange(int[] coins, int amount) {
        var cache = new int[amount + 1];
        Arrays.fill(cache, -1);
        var result = coinChange(coins, amount, cache);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
    
    private static int coinChange(int[] coins, int amount, int[] cache) {
        
        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        if (cache[amount] != -1) {
            return cache[amount];
        }

        var change = Integer.MAX_VALUE;

        for (var i = 0; i < coins.length; i++) {
            var c = coinChange(coins, amount - coins[i], cache);
            if (c != Integer.MAX_VALUE) {
                change = Math.min(change, c + 1);
            }
        }

        return cache[amount] = change;
    }
}