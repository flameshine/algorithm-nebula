class Solution {

    public int removeDuplicates(int[] nums) {

        var result = 2;

        for (var i = 2; i < nums.length; i++) {
            if (nums[i] != nums[result - 2]) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }
}