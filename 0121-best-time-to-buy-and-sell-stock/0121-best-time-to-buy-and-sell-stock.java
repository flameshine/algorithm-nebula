class Solution {
    
    public int maxProfit(int[] prices) {
        
        var result = 0;
        var cheapest = prices[0];

        for (var price : prices) {
            result = Math.max(result, price - cheapest);
            cheapest = Math.min(cheapest, price);
        }

        return result;
    }
}
