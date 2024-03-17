package com.flameshine.nebula.problems.leetcode.learn.binary_search;

import java.util.Arrays;

/**
 * №719 Find K-th Smallest Pair Distance
 *
 * The distance of a pair of integers a and b is defined as the absolute difference between a and b.
 * Given an integer array nums and an integer k, return the kth smallest distance among all the pairs nums[i] and nums[j] where 0 <= i < j < nums.length.
 */
public class FindKthSmallestPairDistance {

    public static void main(String... args) {

        int[] nums = { 1, 3, 1 };

        System.out.println(
            smallestDistancePair(nums, 1)
        );
    }

    private static int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        var min = 0;
        var max = nums[nums.length - 1] - nums[0];

        while (min < max) {
            var middle = min + (max - min) /2;
            var pairsWithDistanceLessThanOrEqualTo = calculatePairsWithDistanceLessThanOrEqualTo(nums, middle);
            if (pairsWithDistanceLessThanOrEqualTo < k) {
                min = middle + 1;
            } else {
                max = middle;
            }
        }

        return min;
    }

    private static int calculatePairsWithDistanceLessThanOrEqualTo(int[] nums, int distance) {

        var total = 0;
        var left = 0;
        var right = 0;

        while (right < nums.length) {
            if (nums[right] - nums[left] <= distance) {
                total += right - left;
                ++right;
            } else {
                ++left;
            }
        }

        return total;
    }
}