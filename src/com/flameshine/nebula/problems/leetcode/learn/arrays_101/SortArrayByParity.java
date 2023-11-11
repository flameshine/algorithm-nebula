package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №905 Sort Array By Parity
 *
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * Return any array that satisfies this condition.
 */
public class SortArrayByParity {

    public static void main(String... args) {

        int[] nums = { 3, 1, 2, 4 };

        System.out.println(
            Arrays.toString(
                sortArrayByParity(nums)
            )
        );
    }

    private static int[] sortArrayByParity(int[] nums) {

        var j = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                var tmp = nums[j];
                nums[j++] = nums[i];
                nums[i] = tmp;
            }
        }

        return nums;
    }
}