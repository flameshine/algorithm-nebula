class Solution {

    public int maxProfit(int[] prices) {
        
        if (prices.length == 0) {
            return 0;
        }
        
        var min = prices[0];
        var result = 0;

        for (var p : prices) {
            min = Math.min(min, p);
            result = Math.max(result, p - min);
        }

        return result;
    }
}