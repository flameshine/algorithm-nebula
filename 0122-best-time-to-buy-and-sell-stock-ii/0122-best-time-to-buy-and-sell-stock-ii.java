class Solution {

    public int maxProfit(int[] prices) {
        
        if (prices.length <= 1) {
            return 0;
        }

        var profit = 0;

        for (var i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return profit;
    }
}