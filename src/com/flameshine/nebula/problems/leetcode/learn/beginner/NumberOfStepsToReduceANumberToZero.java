package com.flameshine.nebula.problems.leetcode.learn.beginner;

/**
 * №1342 Number of Steps to Reduce a Number to Zero
 *
 * Given an integer num, return the number of steps to reduce it to zero.
 * In one step, if the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
 */
public class NumberOfStepsToReduceANumberToZero {

    public static void main(String... args) {
        System.out.println(
            numberOfSteps(14)
        );
    }

    private static int numberOfSteps(int num) {

        var counter = 0;

        while (num != 0) {
            if ((num & 1) == 0) {
                num >>= 1;
            } else {
                --num;
            }
            ++counter;
        }

        return counter;
    }
}