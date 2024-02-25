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

    /**
     * 1. Increment a counter and enter the loop, continuing while the number isn't equal to zero
     * 2. With each iteration check if the number is even and:
     *    - divide it by 2 if so (using the bitwise shift operation)
     *    - decrement the number otherwise
     * 3. Then increment a counter and, after the number became zero, return it
     */
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