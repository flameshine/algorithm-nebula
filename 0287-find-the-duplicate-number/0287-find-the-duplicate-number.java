class Solution {

    public int findDuplicate(int[] nums) {
        
        for (var i = 0; i < nums.length; i++) {
            var index = Math.abs(nums[i]);
            if (nums[index] < 0) {
                return index;
            }
            nums[index] = -nums[index];
        }

        return -1;
    }
}