package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_search;

/**
 * №35 Search Insert Position
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class SearchInsertPosition {

    public static void main(String... args) {

        int[] nums = { 1 };

        System.out.println(
            searchInsert(nums, 1)
        );
    }

    private static int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        var left = 0;
        var right = nums.length - 1;

        while (left < right) {
            var middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return nums[left] < target ? left + 1 : left;
    }
}