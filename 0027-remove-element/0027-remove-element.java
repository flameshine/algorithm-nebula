class Solution {

    public int removeElement(int[] nums, int val) {
        
        var result = 0;

        for (var n : nums) {
            if (n != val) {
                nums[result++] = n;
            }
        }

        return result;
    }
}