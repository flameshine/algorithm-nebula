package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

/**
 * №209 Minimum Size Subarray Sum
 *
 * Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class MinimumSizeSubarraySum {

    public static void main(String... args) {

        int[] nums = { 1, 2, 3, 4, 5 };

        System.out.println(
            minSubArrayLen(11, nums)
        );
    }

    /**
     * 1. Iterate over an array, finding the sum of elements
     * 2. As soon as the sum becomes greater or equal than target, enter another loop, which:
     *    - determines the minimum result, based on the iteration
     *    - moves to the next possible minimum result, reducing the sum if possible while checking the elements
     * 3. If the result was updated, then we found a minimum subarray whose sum is greater than or equal to target
     */
    private static int minSubArrayLen(int target, int[] nums) {

        var result = Integer.MAX_VALUE;
        var pointer = 0;
        var sum = 0;

        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                result = Math.min(result, i + 1 - pointer);
                sum -= nums[pointer++];
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}