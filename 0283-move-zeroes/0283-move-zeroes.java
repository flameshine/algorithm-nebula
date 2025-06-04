class Solution {

    public void moveZeroes(int[] nums) {
        
        var pointer = 0;

        for (var n : nums) {
            if (n != 0) {
                nums[pointer++] = n;
            }
        }

        Arrays.fill(nums, pointer, nums.length, 0);
    }
}