package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №154 Find Minimum in Rotated Sorted Array II
 *
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times.
 * For example, the array nums = [0,1,4,4,5,6,7] might become:
 * - [4,5,6,7,0,1,4] if it was rotated 4 times.
 * - [0,1,4,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 * Given the sorted rotated array nums that may contain duplicates, return the minimum element of this array.
 * You must decrease the overall operation steps as much as possible.
 */
public class FindMinimumInRotatedSortedArray2 {

    public static void main(String... args) {

        int[] nums = { 3, 4, 5, 1, 2 };

        System.out.println(
            findMin(nums)
        );
    }

    private static int findMin(int[] nums) {

        var left = 0;
        var right = nums.length - 1;

        if (nums[left] < nums[right]) {
            return nums[left];
        }

        while (left < right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] < nums[right]) {
                right = middle;
            } else if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                --right;
            }
        }

        return nums[left];
    }
}