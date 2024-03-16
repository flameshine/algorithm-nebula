package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №50 Pow(x, n)
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., x^n).
 */
public class PowXN {

    public static void main(String... args) {
        System.out.println(
            myPow(2, -2)
        );
    }

    private static double myPow(double x, int n) {

        if (n == 0 || x == 1) {
            return 1;
        }

        if (n == 1) {
            return x;
        }

        if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        }

        if ((n & 1) == 0) {
            return myPow(x * x, n / 2);
        }

        return x * myPow(x * x, n / 2);
    }
}