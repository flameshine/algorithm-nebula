package com.flameshine.nebula.problems.leetcode.top_interview_150.sliding_window;

/**
 * №209 Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {

    public static void main(String... args) {

        int[] nums = { 2, 1, 5, 3, 4 };

        System.out.println(
            minSubArrayLen(7, nums)
        );
    }

    private static int minSubArrayLen(int target, int[] nums) {

        var result = Integer.MAX_VALUE;
        var pointer = 0;
        var sum = 0;

        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i + 1 - pointer);
                sum -= nums[pointer];
                ++pointer;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}