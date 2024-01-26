package com.flameshine.nebula.algorithms.sort;

import java.util.Arrays;

/**
 * Implementation of the selection sort algorithm.
 * Complexity: time - O(n^2), space - O(1).
 */
public class SelectionSort {

    public static void main(String... args) {

        int[] array = { 4, 7, 1, 0, 3, 9, 2, 8, 5, 6 };

        sort(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array using the selection sort algorithm.
     *
     * 1. Find the minimum element in the rest of the list with each iteration.
     * 2. Swap it with the current element.
     */
    private static void sort(int[] array) {

        int minIndex;

        for (var i = 0; i < array.length; i++) {

            minIndex = i;

            for (var j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            var tmp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = tmp;
        }
    }
}