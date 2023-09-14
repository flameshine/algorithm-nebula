package com.flameshine.nebula.problems.leetcode.top_interview_150.one_dimension_dp;

/**
 * №70 Climbing Stairs
 *
 * You are climbing a staircase.
 * It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static void main(String... args) {
        System.out.println(
            climbStairs(2)
        );
    }

    private static int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        var previous1 = 1;
        var previous2 = 2;

        for (var i = 3; i <= n; i++) {
            var newValue = previous1 + previous2;
            previous1 = previous2;
            previous2 = newValue;
        }

        return previous2;
    }
}