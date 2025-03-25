class Solution {
    
    public int minEatingSpeed(int[] piles, int h) {
        
        var max = Integer.MIN_VALUE;

        for (var p : piles) {
            max = Math.max(max, p);
        }

        var left = 1;
        var right = max;
        var result = right;

        while (left <= right) {

            var middle = left + (right - left) / 2;
            var hours = 0;

            for (var p : piles) {
                hours += Math.ceil((double) p / middle);
            }

            if (hours <= h) {
                result = Math.min(result, middle);
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return result;
    }
}