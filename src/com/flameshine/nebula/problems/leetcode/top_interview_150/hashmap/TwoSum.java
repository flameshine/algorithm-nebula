package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

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
            Arrays.toString(twoSum(nums, 9))
        );
    }

    private static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numberToIndex = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {

            var difference = target - nums[i];

            if (numberToIndex.containsKey(difference)) {
                return new int[] { numberToIndex.get(difference), i };
            }

            numberToIndex.put(nums[i], i);
        }

        throw new IllegalStateException();
    }
}