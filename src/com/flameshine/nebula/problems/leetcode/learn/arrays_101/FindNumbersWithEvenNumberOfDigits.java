package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

/**
 * №1295 Find Numbers with Even Number of Digits
 *
 * Given an array nums of integers, return how many of them contain an even number of digits.
 */
public class FindNumbersWithEvenNumberOfDigits {

    public static void main(String... args) {

        int[] nums = { 12, 345, 2, 6, 7896 };

        System.out.println(
            findNumbers(nums)
        );
    }

    private static int findNumbers(int[] nums) {

        var counter = 0;

        for (var num : nums) {
            if (Integer.toString(num).length() % 2 == 0) {
                ++counter;
            }
        }

        return counter;
    }
}