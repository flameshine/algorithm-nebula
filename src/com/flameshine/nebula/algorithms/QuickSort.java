package com.flameshine.nebula.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String... args) {

        int[] array = { 5, 7, 3, 9, 8, 2, 1, 4, 6 };

        sort(array, 0, array.length - 1);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array using a quick sort algorithm.
     *
     * 1. We're determining the range of elements so:
     *    - items inside are duplicate
     *    - items before the lower boundary are lower
     *    - items after the higher boundary are greater
     * 2. After the elements are placed as described, sort both parts and repeat the process recursively.
     */
    private static void sort(int[] array, int start, int end) {

        if (start >= end) {
            return;
        }

        var lowerBoundary = start;
        var higherBoundary = end;
        var pivot = array[start];
        var i = start;

        while (i <= higherBoundary) {
            if (array[i] < pivot) {
                exchange(array, lowerBoundary++, i++);
            } else if (array[i] > pivot) {
                exchange(array, i, higherBoundary--);
            } else {
                ++i;
            }
        }

        sort(array, start, lowerBoundary - 1);
        sort(array, higherBoundary + 1, end);
    }

    private static void exchange(int[] array, int first, int second) {
        var temporary = array[first];
        array[first] = array[second];
        array[second] = temporary;
    }
}