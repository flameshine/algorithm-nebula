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

        var result = -1;

        for (var i = 0; i < coins.length; i++) {

            var change = coinChange(coins, amount - coins[i], memory);
            
            if (change >= 0) {
                result = result < 0 ? change + 1 : Math.min(result, change + 1);
            }
        }

        memory.put(amount, result);

        return result;
    }
}