package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

/**
 * №279 Perfect Squares
 *
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class PerfectSquares {

    public static void main(String... args) {
        System.out.println(
            numSquares(12)
        );
    }

    private static int numSquares(int n) {

        var dp = new int[n + 1];

        dp[0] = 0;

        for (var i = 1; i <= n; i++) {
            dp[i] = i;
            for (var j = 1; j * j <= i; j++) {
                var square = j * j;
                dp[i] = Math.min(dp[i], 1 + dp[i - square]);
            }
        }

        return dp[n];
    }
}