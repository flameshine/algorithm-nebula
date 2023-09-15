package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

import java.util.Arrays;

/**
 * №238 Product of Array Except Self
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 */
public class ProductOfArrayExceptSelf {

    public static void main(String... args) {

        int[] nums = { 1, 2, 3, 4 };

        System.out.println(
            Arrays.toString(productExceptSelf(nums))
        );
    }

    private static int[] productExceptSelf(int[] nums) {

        var prefix = new int[nums.length];
        var suffix = new int[nums.length];

        prefix[0] = 1;
        suffix[nums.length - 1] = 1;

        for (var i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] * nums[i - 1];
        }

        for (var i = nums.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * nums[i + 1];
        }

        var result = new int[nums.length];

        for (var i = 0; i < nums.length; i++) {
            result[i] = prefix[i] * suffix[i];
        }

        return result;
    }
}