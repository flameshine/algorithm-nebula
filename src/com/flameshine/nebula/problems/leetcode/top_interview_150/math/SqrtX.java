package com.flameshine.nebula.problems.leetcode.top_interview_150.math;

/**
 * №69 Sqrt(x)
 *
 * Given a non-negative integer x, return the square root of x rounded down to the nearest integer.
 * The returned integer should be non-negative as well.
 * You must not use any built-in exponent function or operator.
 * For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.
 */
public class SqrtX {

    public static void main(String... args) {
        System.out.println(
            mySqrt(2147483647)
        );
    }

    private static int mySqrt(int x) {

        long result = x;

        while (result * result > x) {
            result = (result + x / result) / 2;
        }

        return (int) result;
    }
}