package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №283 Move Zeroes
 *
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 */
public class MoveZeroes {

    public static void main(String... args) {

        int[] nums = { 0, 1, 0, 3, 12 };

        moveZeroes(nums);

        System.out.println(
            Arrays.toString(nums)
        );
    }

    /**
     * 1. Iterate over an array, skipping all zeroes and assigning them the next item from an array
     * 2. Assign zeros for the rest, empty slots
     */
    private static void moveZeroes(int[] nums) {

        var pointer = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }

        while (pointer <= nums.length - 1) {
            nums[pointer++] = 0;
        }
    }
}