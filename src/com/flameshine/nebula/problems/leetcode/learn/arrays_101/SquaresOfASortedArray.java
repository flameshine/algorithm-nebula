package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №977 Squares of a Sorted Array
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfASortedArray {

    public static void main(String... args) {

        int[] nums = { -4, -1, 0, 3, 10 };

        System.out.println(
            Arrays.toString(sortedSquares(nums))
        );
    }

    private static int[] sortedSquares(int[] nums) {

        var left = 0;
        var right = nums.length - 1;
        var result = new int[nums.length];
        var counter = right;

        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                result[counter] = nums[left] * nums[left];
                ++left;
            } else {
                result[counter] = nums[right] * nums[right];
                --right;
            }
            --counter;
        }

        return result;
    }
}