package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * №136 Single Number
 *
 * Given a non-empty array of integers nums, every element appears twice except for one.
 * Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

    public static void main(String... args) {

        int[] nums = { 2, 2, 1 };

        System.out.println(
            singleNumber(nums)
        );
    }

    private static int singleNumber(int[] nums) {

        var result = 0;

        for (var num : nums) {
            result ^= num;
        }

        return result;
    }
}