class Solution {

    public boolean canJump(int[] nums) {
        
        var reachable = 0;

        for (var i = 0; i < nums.length; i++) {

            if (i > reachable) {
                return false;
            }

            reachable = Math.max(reachable, i + nums[i]);
        }

        return true;
    }
}