package com.flameshine.nebula.algorithms.sort;

import java.util.Arrays;

/**
 * Implementation of the bubble sort algorithm.
 * Complexity: time - O(n^2), space - O(1).
 */
public class BubbleSort {

    public static void main(String... args) {

        int[] array = { 4, 7, 1, 0, 3, 9, 2, 8, 5, 6 };

        sort(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array using the bubble sort algorithm.
     *
     * 1. Initialize the "swapped" boolean variable which will track if the elements were swapped during the certain iteration.
     * 2. While we're swapping the elements, reset it to false with each iteration.
     * 3. Inside the loop, iterate over elements of the array, swapping them if needed, switching the "swapped" value.
     */
    private static void sort(int[] array) {

        var swapped = true;

        while (swapped) {
            swapped = false;
            for (var i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    var tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }
}