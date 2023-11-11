package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №1299 Replace Elements with Greatest Element on Right Side
 *
 * Given an array arr, replace every element in that array with the greatest element among the elements to its right, and replace the last element with -1.
 * After doing so, return the array.
 */
public class ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String... args) {

        int[] arr = { 17, 18, 5, 4, 6, 1 };

        System.out.println(
            Arrays.toString(
                replaceElements(arr)
            )
        );
    }

    private static int[] replaceElements(int[] arr) {

        var max = -1;

        for (var i = arr.length - 1; i >= 0; i--) {
            var tmp = arr[i];
            arr[i] = max;
            max = Math.max(max, tmp);
        }

        return arr;
    }
}