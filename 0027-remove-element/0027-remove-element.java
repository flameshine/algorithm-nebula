class Solution {
    public int removeElement(int[] nums, int val) {

        var result = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[result++] = nums[i];
            }
        }

        return result;
    }
}