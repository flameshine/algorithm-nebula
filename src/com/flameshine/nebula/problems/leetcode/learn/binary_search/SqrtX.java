package com.flameshine.nebula.problems.leetcode.learn.binary_search;

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
            mySqrt(9)
        );
    }

    /**
     * 1. Iterate over an array, applying the binary search approach, where the left boundary is 1 and the right one is the number
     * 2. With each iteration, check if the number divided by the half of the boundaries sum is equal to the same sum
     */
    private static int mySqrt(int x) {

        var left = 1;
        var right = x;

        while (left <= right) {
            var middle = (left + right) / 2;
            if (x / middle == middle) {
                return middle;
            } else if (middle > x / middle) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        return right;
    }
}