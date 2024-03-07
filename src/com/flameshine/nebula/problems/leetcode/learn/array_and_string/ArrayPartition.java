package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.Arrays;

/**
 * №561 Array Partition
 *
 * Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized.
 * Return the maximized sum.
 */
public class ArrayPartition {

    public static void main(String... args) {

        int[] nums = { 6, 2, 6, 5, 1, 2 };

        System.out.println(
            arrayPairSum(nums)
        );
    }

    private static int arrayPairSum(int[] nums) {

        Arrays.sort(nums);

        var result = 0;

        for (var i = 0; i < nums.length; i += 2) {
            result += nums[i];
        }

        return result;
    }
}