class Solution {

    public void moveZeroes(int[] nums) {
        
        var pointer = 0;

        for (var n : nums) {
            if (n != 0) {
                nums[pointer++] = n;
            }
        }

        while (pointer <= nums.length - 1) {
            nums[pointer++] = 0;
        }
    }
}