class Solution {

    public void moveZeroes(int[] nums) {
        
        var lastZeroIndex = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                var tmp = nums[i];
                nums[i] = 0;
                nums[lastZeroIndex++] = tmp;
            }
        }
    }
}