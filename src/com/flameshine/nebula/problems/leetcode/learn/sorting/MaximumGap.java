package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.Arrays;

/**
 * №164 Maximum Gap
 *
 * Given an integer array nums, return the maximum difference between two successive elements in its sorted form.
 * If the array contains less than two elements, return 0.
 * You must write an algorithm that runs in linear time and uses linear extra space.
 */
public class MaximumGap {

    public static void main(String... args) {

        var nums = new int[] { 3, 6, 9, 1 };

        System.out.println(
            maximumGap(nums)
        );
    }

    private static int maximumGap(int[] nums) {

        Arrays.sort(nums);

        var result = 0;

        for (var i = 1; i < nums.length; i++) {
            result = Math.max(result, nums[i] - nums[i - 1]);
        }

        return result;
    }
}