package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * №219 Contains Duplicate II
 *
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.
 */
public class ContainsDuplicate2 {

    public static void main(String... args) {

        var nums = new int[] { 1, 2, 3, 1, 2, 3 };

        System.out.println(
            containsNearbyDuplicate(nums, 2)
        );
    }

    private static boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer, Integer> numberToPosition = new HashMap<>();

        for (var i = 0; i < nums.length; i++) {
            if (numberToPosition.containsKey(nums[i]) && Math.abs(numberToPosition.get(nums[i]) - i) <= k) {
                return true;
            }
            numberToPosition.put(nums[i], i);
        }

        return false;
    }
}