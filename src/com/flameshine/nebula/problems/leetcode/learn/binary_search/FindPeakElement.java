package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №162 Find Peak Element
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 */
public class FindPeakElement {

    public static void main(String... args) {

        var nums = new int[] { 1, 2, 3, 1 };

        System.out.println(
            findPeakElement(nums)
        );
    }

    /**
     * 1. First, check if it's the single element array or if the first number is a peak element
     * 2. Check if the last number is a peak element
     * 3. Using the binary search algorithm, find the peak element
     */
    private static int findPeakElement(int[] nums) {

        if (nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }

        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        var left = 1;
        var right = nums.length - 2;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (nums[middle] > nums[middle - 1] && nums[middle] > nums[middle + 2]) {
                return middle;
            } else if (nums[middle] < nums[middle - 1]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return -1;
    }
}