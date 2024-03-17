package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №287 Find the Duplicate Number
 *
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindTheDuplicateNumber {

    public static void main(String... args) {

        int[] nums = { 3, 4, 5, 2, 2 };

        System.out.println(
            findDuplicate(nums)
        );
    }

    private static int findDuplicate(int[] nums) {

        var left = 0;
        var right = nums.length - 1;

        while (left < right) {
            var middle = left + (right - left) / 2;
            var count = 0;
            for (var n : nums) {
                if (n <= middle) {
                    ++count;
                }
            }
            if (count > middle) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}