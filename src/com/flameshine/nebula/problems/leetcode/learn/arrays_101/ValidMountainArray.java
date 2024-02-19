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

    /**
     * 1. Check if the array length is lower than 3 and return false is so, as this can't be a mountain array
     * 2. Increment a counter while the items in an array are in ascending order
     * 3. Check if the counter equal to an array length or didn't change and return false if so
     * 4. Increment a counter while all the next items are in descending order
     * 5. If the counter's value equal to an array length, return true
     * 6. Otherwise, return false
     */
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