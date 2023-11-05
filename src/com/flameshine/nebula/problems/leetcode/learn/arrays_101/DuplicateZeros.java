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

        int[] arr = { 1, 0, 2, 3, 0, 4, 5, 0 };

        duplicateZeros(arr);

        System.out.println(
            Arrays.toString(arr)
        );
    }

    private static void duplicateZeros(int[] arr) {

        List<Integer> container = new ArrayList<>(arr.length);

        for (var i : arr) {
            if (i == 0) {
                container.add(0);
                container.add(0);
            } else {
                container.add(i);
            }
        }

        for (var i = 0; i < arr.length; i++) {
            arr[i] = container.get(i);
        }
    }
}