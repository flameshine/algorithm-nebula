class Solution {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> memory = new HashMap<>();
        var result = coinChange(coins, amount, memory);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private static int coinChange(int[] coins, int amount, Map<Integer, Integer> memory) {

        if (amount == 0) {
            return 0;
        }

        if (amount < 0) {
            return Integer.MAX_VALUE;
        }

        var previouslyComputedChange = memory.get(amount);

        if (previouslyComputedChange != null) {
            return previouslyComputedChange;
        }

        var result = Integer.MAX_VALUE;

        for (var i = 0; i < coins.length; i++) {

            var change = coinChange(coins, amount - coins[i], memory);
            
            if (change != Integer.MAX_VALUE) {
                result = Math.min(result, change + 1);
            }
        }

        memory.put(amount, result);

        return result;
    }
}