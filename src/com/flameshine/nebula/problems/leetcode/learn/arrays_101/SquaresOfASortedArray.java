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

    /**
     * 1. Initialize all necessary values
     * 2. Iterate over an array using two pointers approach, when the first one points at the beginning of the array and the second one at the end
     * 3. If the absolute value behind the left pointer is greater than the corresponding one behind the right pointer:
     *    - add its product to the resulting array
     *    - increment the left pointer
     * 4. Otherwise, add the right's value product to the result and decrement the right one
     * 5. Decrement the resulting array index counter to place the next value on a new slot
     */
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