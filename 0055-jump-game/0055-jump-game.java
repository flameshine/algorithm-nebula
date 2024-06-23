class Solution {

    public boolean canJump(int[] nums) {
        
        var furthest = 0;

        for (var i = 0; i < nums.length; i++) {
            if (i > furthest) {
                return false;
            }
            furthest = Math.max(furthest, i + nums[i]);
        }

        return true;
    }
}