package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

/**
 * №485 Max Consecutive Ones
 *
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */
public class MaxConsecutiveOnes {

    public static void main(String... args) {

        int[] nums = { 1, 1, 0, 1, 1, 1 };

        System.out.println(
            findMaxConsecutiveOnes(nums)
        );
    }

    /**
     * 1. Iterate over an array following these conditions:
     *    - if the number is equal to 1, increment a counter
     *    - otherwise, zero it
     *    - at the end of each iteration, update the max value
     * 2. Return the result
     */
    private static int findMaxConsecutiveOnes(int[] nums) {

        var maxConsequence = 0;
        var counter = 0;

        for (var num : nums) {
            if (num == 1) {
                ++counter;
            } else {
                counter = 0;
            }
            maxConsequence = Math.max(maxConsequence, counter);
        }

        return maxConsequence;
    }
}