class Solution {

    public int jump(int[] nums) {
    
        var furthest = 0;
        var currentEnd = 0;
        var jumps = 0;

        for (var i = 0; i < nums.length - 1; i++) {

            furthest = Math.max(furthest, i + nums[i]);

            if (i == currentEnd) {
                ++jumps;
                currentEnd = furthest;
            }
        }

        return jumps;
    }
}