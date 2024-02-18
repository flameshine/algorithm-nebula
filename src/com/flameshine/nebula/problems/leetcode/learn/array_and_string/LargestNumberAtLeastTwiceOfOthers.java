package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

/**
 * №747 Largest Number At Least Twice of Others
 *
 * You are given an integer array nums where the largest integer is unique.
 * Determine whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, or return -1 otherwise.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public static void main(String... args) {

        int[] nums = { 3, 6, 1, 0 };

        System.out.println(
            dominantIndex(nums)
        );
    }

    /**
     * 1. Iterate over an array, finding the highest and the second-highest element in the array
     * 2. If the highest number if twice as big as the second-highest, we found the dominant index
     */
    private static int dominantIndex(int[] nums) {

        var highest = 0;
        var secondHighest = 0;
        var position = 0;

        for (var i = 0; i < nums.length; i++) {
            if (nums[i] > highest) {
                secondHighest = highest;
                highest = nums[i];
                position = i;
            } else {
                secondHighest = Math.max(secondHighest, nums[i]);
            }
        }

        return highest >= secondHighest * 2 ? position : -1;
    }
}