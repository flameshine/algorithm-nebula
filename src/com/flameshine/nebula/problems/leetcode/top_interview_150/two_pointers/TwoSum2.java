package com.flameshine.nebula.problems.leetcode.top_interview_150.two_pointers;

import java.util.Arrays;

/**
 * №167 Two Sum II
 *
 * Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number.
 * Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 < numbers.length.
 * Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
 * The tests are generated such that there is exactly one solution.
 * You may not use the same element twice.
 * Your solution must use only constant extra space.
 */
public class TwoSum2 {

    public static void main(String... args) {

        int[] numbers = { 2, 7, 11, 15 };

        System.out.println(
            Arrays.toString(twoSum(numbers, 9))
        );
    }

    private static int[] twoSum(int[] numbers, int target) {

        var left = 0;
        var right = numbers.length - 1;

        while (left < right) {
            var sum = numbers[left] + numbers[right];
            if (sum > target) {
                --right;
            } else if (sum < target) {
                ++left;
            } else {
                return new int[] { left + 1, right + 1 };
            }
        }

        throw new IllegalStateException();
    }
}