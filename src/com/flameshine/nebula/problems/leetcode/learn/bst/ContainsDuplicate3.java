package com.flameshine.nebula.problems.leetcode.learn.bst;

/**
 * №220 Contains Duplicate III
 *
 * You are given an integer array nums and two integers indexDiff and valueDiff.
 * Find a pair of indices (i, j) such that:
 * - i != j,
 * - abs(i - j) <= indexDiff.
 * - abs(nums[i] - nums[j]) <= valueDiff
 * Return true if such pair exists or false otherwise.
 */
public class ContainsDuplicate3 {

    public static void main(String... args) {

        var nums = new int[] { 1, 2, 3, 1 };

        System.out.println(
            containsNearbyAlmostDuplicate(nums, 3, 0)
        );
    }

    private static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        for (var i = 0; i < nums.length; i++) {
            for (var j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) <= indexDiff && Math.abs(nums[i] - nums[j]) <= valueDiff) {
                    return true;
                }
            }
        }

        return false;
    }
}