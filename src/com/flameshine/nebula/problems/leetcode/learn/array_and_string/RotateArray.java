package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.Arrays;

/**
 * №189 Rotate Array
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {

    public static void main(String... args) {

        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };

        rotate(nums, 3);

        System.out.println(
            Arrays.toString(nums)
        );
    }

    /**
     * 1. Remove unnecessary rotations, dividing k with modulus by the length of an array
     * 2. Rotate the entire array
     * 3. Rotate the array prior the k-th index
     * 4. Rotate the array after the k-th index
     */
    private static void rotate(int[] nums, int k) {

        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            var tmp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = tmp;
        }
    }
}