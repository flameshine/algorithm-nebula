package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №367 Valid Perfect Square
 *
 * Given a positive integer num, return true if num is a perfect square or false otherwise.
 * A perfect square is an integer that is the square of an integer.
 * In other words, it is the product of some integer with itself.
 * You must not use any built-in library function, such as sqrt.
 */
public class ValidPerfectSquare {

    public static void main(String... args) {
        System.out.println(
            isPerfectSquare(14)
        );
    }

    private static boolean isPerfectSquare(int num) {

        if (num <= 1) {
            return true;
        }

        var left = 1;
        var right = num;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            var square = middle * middle;
            if (square == num) {
                return true;
            } else if (square < num) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
}