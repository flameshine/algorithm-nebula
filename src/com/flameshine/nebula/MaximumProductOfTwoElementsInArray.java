package com.flameshine.nebula;

import java.util.Arrays;

/**
 * Problem statement:
 *
 * Given the array of integers, you will choose two different indices i and j of that array.
 * Return the maximum value of (numbers[i] - 1) * (numbers[j] - 1).
 */

public final class MaximumProductOfTwoElementsInArray {

    public static void main(String... args) {

        var numbers = new int[] { 3, 4, 5, 2 };

        System.out.println(
            maxProduct(numbers)
        );
    }

    private static int maxProduct(int[] numbers) {

        Arrays.sort(numbers);

        return (numbers[numbers.length - 2] - 1) * (numbers[numbers.length - 1] - 1);
    }
}