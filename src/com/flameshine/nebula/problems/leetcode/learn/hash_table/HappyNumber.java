package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * №202 Happy Number
 *
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 *   - Starting with any positive integer, replace the number by the sum of the squares of its digits.
 *   - Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 *   - Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 */
public class HappyNumber {

    public static void main(String... args) {
        System.out.println(
            isHappy(19)
        );
    }

    private static boolean isHappy(int n) {

        Set<Integer> seen = new HashSet<>();

        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = sumOfSquaredDigits(n);
        }

        return n == 1;
    }

    private static int sumOfSquaredDigits(int n) {

        var sum = 0;

        while (n != 0) {
            var digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}