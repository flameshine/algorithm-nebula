package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

/**
 * №1089 Duplicate Zeros
 *
 * Given a fixed-length integer array arr, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * Note that elements beyond the length of the original array are not written.
 * Do the above modifications to the input array in place and do not return anything.
 */
public class DuplicateZeros {

    public static void main(String... args) {

        int[] array = { 1, 0, 2, 3, 0, 4, 5, 0 };

        duplicateZeros(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * 1. Iterate over an array, adding its items to the container list
     * 2. If the encountered item is equal to zero, add two copies of it
     * 3. Assign the resulting array values from the built container
     */
    private static void duplicateZeros(int[] array) {

        List<Integer> container = new ArrayList<>(array.length);

        for (var i : array) {
            if (i == 0) {
                container.add(0);
                container.add(0);
            } else {
                container.add(i);
            }
        }

        for (var i = 0; i < array.length; i++) {
            array[i] = container.get(i);
        }
    }
}