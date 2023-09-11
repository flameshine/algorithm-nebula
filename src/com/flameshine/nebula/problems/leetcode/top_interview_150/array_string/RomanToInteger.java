package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * №13 Roman to Integer
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * For example, 2 is written as II in Roman numeral, just two ones added together.
 * 12 is written as XII, which is simply X + II.
 * The number 27 is written as XXVII, which is XX + V + II.
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII.
 * Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX.
 *
 * There are six instances where subtraction is used:
 *
 *   - I can be placed before V (5) and X (10) to make 4 and 9.
 *   - X can be placed before L (50) and C (100) to make 40 and 90.
 *   - C can be placed before D (500) and M (1000) to make 400 and 900.
 *
 * Given a roman numeral, convert it to an integer.
 */
public class RomanToInteger {

    public static void main(String... args) {
        System.out.println(
            romanToInt("MCMXCIV")
        );
    }

    private static int romanToInt(String s) {

        var result = 0;
        var previous = 0;

        for (var i = s.length() - 1; i >= 0; i--) {

            var value = 0;

            switch (s.charAt(i)) {
                case 'M' -> value = 1000;
                case 'D' -> value = 500;
                case 'C' -> value = 100;
                case 'L' -> value = 50;
                case 'X' -> value = 10;
                case 'V' -> value = 5;
                case 'I' -> value = 1;
            }

            if (value < previous) {
                result -= value;
            } else {
                result += value;
            }

            previous = value;
        }

        return result;
    }
}