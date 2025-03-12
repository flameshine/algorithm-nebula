class Solution {
    
    public boolean increasingTriplet(int[] nums) {
        
        var low = Integer.MAX_VALUE;
        var high = Integer.MAX_VALUE;

        for (var n : nums) {
            if (n <= low) {
                low = n;
            } else if (n <= high) {
                high = n;
            } else {
                return true;
            }
        }

        return false;
    }
}