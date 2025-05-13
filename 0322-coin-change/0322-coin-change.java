class Solution {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memory = new HashMap<>();
        return coinChange(coins, amount, memory);
    }

    private static int coinChange(int[] coins, int amount, Map<Integer, Integer> memory) {

        if (amount < 0) {
            return -1;
        }

        if (amount == 0) {
            return 0;
        }

        var previouslyComputedChange = memory.get(amount);

        if (previouslyComputedChange != null) {
            return previouslyComputedChange;
        }

        var change = -1;

        for (var i = 0; i < coins.length; i++) {

            var coin = coinChange(coins, amount - coins[i], memory);
            
            if (coin >= 0) {
                change = change < 0 ? coin + 1 : Math.min(change, coin + 1);
            }
        }

        memory.put(amount, change);

        return change;
    }
}