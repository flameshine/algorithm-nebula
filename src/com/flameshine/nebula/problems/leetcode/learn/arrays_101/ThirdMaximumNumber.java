package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №414 Third Maximum Number
 *
 * Given an integer array nums, return the third distinct maximum number in this array.
 * If the third maximum does not exist, return the maximum number.
 */
public class ThirdMaximumNumber {

    public static void main(String... args) {

        int[] nums = { 2, 2, 3, 1 };

        System.out.println(
            thirdMax(nums)
        );
    }

    private static int thirdMax(int[] nums) {

        if (nums.length == 1) {
            return nums[0];
        }

        var distinctSortedNumbers = Arrays.stream(nums)
            .sorted()
            .distinct()
            .toArray();

        return distinctSortedNumbers.length >= 3 ?
            distinctSortedNumbers[distinctSortedNumbers.length - 3] :
            distinctSortedNumbers[distinctSortedNumbers.length - 1];
    }
}