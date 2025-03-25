class Solution {

    public int findPeakElement(int[] nums) {
        
        var left = 0;
        var right = nums.length - 1;

        while (left < right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}