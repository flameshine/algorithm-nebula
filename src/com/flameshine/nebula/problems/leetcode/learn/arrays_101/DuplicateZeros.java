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