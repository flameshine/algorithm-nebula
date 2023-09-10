package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

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
            isHappy(2)
        );
    }

    private static boolean isHappy(int n) {
        return isHappy(n, new HashSet<>());
    }

    private static boolean isHappy(int n, Set<Integer> seen) {

        if (n == 1) {
            return true;
        }

        if (seen.contains(n)) {
            return false;
        }

        seen.add(n);

        return isHappy(squareSumOfDigits(n), seen);
    }

    private static int squareSumOfDigits(int n) {

        var sum = 0;

        while (n != 0) {
            var digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }
}