package com.flameshine.nebula.problems.leetcode.learn.beginner;

import java.util.Arrays;

/**
 * №1480 Running Sum of 1d Array
 *
 * Given an array nums.
 * We define a running sum of an array as runningSum[i] = sum(nums[0]...nums[i]).
 * Return the running sum of nums.
 */
public class RunningSum {

    public static void main(String... args) {

        int[] nums = { 3, 1, 2, 10, 1 };

        System.out.println(
            Arrays.toString(runningSum(nums))
        );
    }

    /**
     * 1. Iterate over the elements in an array
     * 2. With each iteration add the previous value to the current one
     */
    private static int[] runningSum(int[] nums) {

        for (var i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        return nums;
    }
}