class Solution {
    
    public int search(int[] nums, int target) {
        
        var left = 0;
        var right = nums.length - 1;

        while (left <= right) {

            var middle = left + (right - left) / 2;

            if (nums[middle] > target) {
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}