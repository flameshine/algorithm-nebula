class Solution {

    public int maxProfit(int[] prices, int fee) {
        
        var buy = Integer.MIN_VALUE;
        var sell = 0;

        for (var p : prices) {
            buy = Math.max(buy, sell - p);
            sell = Math.max(sell, buy + p - fee);
        }

        return sell;
    }
}