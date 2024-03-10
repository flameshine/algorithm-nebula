package com.flameshine.nebula.problems.leetcode.learn.binary_search;

import java.util.Arrays;

/**
 * №34 Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String... args) {

        int[] nums = { 5, 7, 7, 8, 8, 10 };

        System.out.println(
            Arrays.toString(searchRange(nums, 8))
        );
    }

    private static int[] searchRange(int[] nums, int target) {
        var first = findFirst(nums, target);
        var last = findLast(nums, target);
        return new int[] { first, last };
    }

    private static int findFirst(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;
        var first = -1;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                first = middle;
                right = middle - 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return first;
    }

    private static int findLast(int[] nums, int target) {

        var left = 0;
        var right = nums.length - 1;
        var last = -1;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] == target) {
                last = middle;
                left = middle + 1;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return last;
    }
}