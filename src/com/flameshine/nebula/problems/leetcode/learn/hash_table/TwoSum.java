package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * №1 Two Sum
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
public class TwoSum {

    public static void main(String... args) {

        int[] nums = { 2, 7, 11, 15 };

        System.out.println(
            Arrays.toString(
                twoSum(nums, 9)
            )
        );
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> targetToIndex = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {
            if (targetToIndex.containsKey(nums[i])) {
                return new int[] { i, targetToIndex.get(nums[i]) };
            }
            targetToIndex.put(target - nums[i], i);
        }

        throw new IllegalStateException();
    }
}