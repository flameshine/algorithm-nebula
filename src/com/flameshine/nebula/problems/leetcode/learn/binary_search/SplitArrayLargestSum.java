package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №410 Split Array Largest Sum
 *
 * Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
 * Return the minimized largest sum of the split.
 * A subarray is a contiguous part of the array.
 */
public class SplitArrayLargestSum {

    public static void main(String... args) {

        int[] nums = { 7, 2, 5, 10, 8 };

        System.out.println(
            splitArray(nums, 2)
        );
    }

    private static int splitArray(int[] nums, int k) {

        var low = 0;
        var high = 0;

        for (var num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        while (low <= high) {
            var middle = low + (high - low) / 2;
            if (isSubarrayPossible(nums, k, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return low;
    }

    private static boolean isSubarrayPossible(int[] nums, int k, int middle) {

        var subarraySize = 0;
        var counter = 0;

        for (var num : nums) {
            if (counter + num <= middle) {
                counter += num;
            } else {
                subarraySize++;
                counter = num;
            }
        }

        return subarraySize >= k;
    }
}