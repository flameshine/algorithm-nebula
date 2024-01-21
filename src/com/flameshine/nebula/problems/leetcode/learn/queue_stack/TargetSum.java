package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * №494 Target Sum
 *
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class TargetSum {

    public static void main(String... args) {

        var nums = new int[] { 1, 1, 1, 1, 1 };

        System.out.println(
            findTargetSumWays(nums, 3)
        );
    }

    private static int findTargetSumWays(int[] nums, int target) {
        var count = new AtomicInteger(0);
        findTargetSumWaysHelper(nums, 0, 0, target, count);
        return count.get();
    }

    private static void findTargetSumWaysHelper(int[] nums, int i, int sum, int target, AtomicInteger count) {

        if (i == nums.length) {
            if (sum == target) {
                count.incrementAndGet();
            }
            return;
        }

        findTargetSumWaysHelper(nums, i + 1, sum + nums[i], target, count);
        findTargetSumWaysHelper(nums, i + 1, sum - nums[i], target, count);
    }
}