package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

/**
 * №941 Valid Mountain Array
 *
 * Given an array of integers arr, return true if and only if it is a valid mountain array.
 * Recall that arr is a mountain array if and only if:
 *   - arr.length >= 3
 *   - There exists some i with 0 < i < arr.length - 1 such that:
 *       - arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
 *       - arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
 */
public class ValidMountainArray {

    public static void main(String... args) {

        int[] array = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

        System.out.println(
            validMountainArray(array)
        );
    }

    private static boolean validMountainArray(int[] array) {

        if (array.length < 3) {
            return false;
        }

        var i = 1;

        while (i < array.length && array[i] > array[i - 1]) {
            ++i;
        }

        if (i == array.length || i == 1) {
            return false;
        }

        while (i < array.length && array[i] < array[i - 1]) {
            ++i;
        }

        return i == array.length;
    }
}