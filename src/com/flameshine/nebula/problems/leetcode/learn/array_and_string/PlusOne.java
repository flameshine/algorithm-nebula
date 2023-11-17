package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.Arrays;

/**
 * №66 Plus One
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 */
public class PlusOne {

    public static void main(String... args) {

        int[] digits = { 9 };

        System.out.println(
            Arrays.toString(
                plusOne(digits)
            )
        );
    }

    private static int[] plusOne(int[] digits) {

        for (var i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        var extended = new int[digits.length + 1];

        extended[0] = 1;

        return extended;
    }
}