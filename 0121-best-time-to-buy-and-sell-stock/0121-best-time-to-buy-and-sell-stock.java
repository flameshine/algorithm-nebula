class Solution {

    public int maxProfit(int[] prices) {
        
        var result = 0;
        var min = Integer.MAX_VALUE;

        for (var p : prices) {
            min = Math.min(min, p);
            result = Math.max(result, p - min);
        }

        return result;
    }
}