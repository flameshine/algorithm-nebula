package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.List;
import java.util.ArrayList;

/**
 * №448 Find All Numbers Disappeared in an Array
 *
 * Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class FindAllNumbersDisappearedInAnArray {

    public static void main(String... args) {

        int[] nums = { 4, 3, 2, 7, 8, 2, 3, 1 };

        System.out.println(
            findDisappearedNumbers(nums)
        );
    }

    /**
     * 1. Initialize a boolean array
     * 2. Iterate over items in the input array assigning true to the corresponding slot of the boolean array
     * 3. Iterate over the numbers again, adding all numbers which corresponding slots are false to the result
     */
    private static List<Integer> findDisappearedNumbers(int[] nums) {

        var existing = new boolean[nums.length];

        for (var n : nums) {
            existing[n - 1] = true;
        }

        List<Integer> result = new ArrayList<>();

        for (var i = 0; i < nums.length; i++) {
            if (!existing[i]) {
                result.add(i + 1);
            }
        }

        return result;
    }
}