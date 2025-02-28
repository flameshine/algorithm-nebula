class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        var first = findFirst(nums, target);
        var last = findLast(nums, target);
        return new int[] { first, last };
    }

    private static int findFirst(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;
        var result = -1;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                result = middle;
                right = middle - 1;
            }
        }

        return result;
    }

    private static int findLast(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;
        var result = -1;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] < target) {
                left = middle + 1;
            } else if (nums[middle] > target) {
                right = middle - 1;
            } else {
                result = middle;
                left = middle + 1;
            }
        }

        return result;
    }
}