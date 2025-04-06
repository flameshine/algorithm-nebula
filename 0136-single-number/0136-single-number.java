class Solution {

    public int singleNumber(int[] nums) {
        
        var result = 0;

        for (var n : nums) {
            result ^= n;
        }

        return result;
    }
}