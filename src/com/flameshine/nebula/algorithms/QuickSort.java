package com.flameshine.nebula.algorithms;

import java.util.Arrays;

public class QuickSort {

    public static void main(String... args) {

        var array = new int[] { 5, 7, 3, 9, 8, 2, 1, 4, 6 };

        sort(array, 0, array.length - 1);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array using a quick sort algorithm.
     *
     * 1. Until we sorted the array, repeat:
     *    - determine the partition index, all the elements before it are lower and all the elements after it are greater
     *    - recursively call this function for the left partition
     *    - recursively call this function for the right partition
     */
    private static void sort(int[] array, int start, int end) {
        if (start < end) {
            var partitionIndex = partition(array, start, end);
            sort(array, start, partitionIndex - 1);
            sort(array, partitionIndex + 1, end);
        }
    }

    /**
     * An utility function to partition the array.
     *
     * 1. Define the pivot (in our case, it's the last element)
     * 2. Iterate over an array, finding the proper position for the pivot element so:
     *    - all elements before the pivot are lower
     *    - all elements after the pivot are greater
     * 3. Set the last element (pivot) on its position, swapping it with the element from the right partition.
     * 4. Return the pivot index.
     */
    private static int partition(int[] array, int start, int end) {

        var pivot = array[end];
        var i = start - 1;

        for (var j = start; j < end; j++) {
            if (array[j] <= pivot) {
                ++i;
                var temporary = array[i];
                array[i] = array[j];
                array[j] = temporary;
            }
        }

        var temporary = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temporary;

        return i + 1;
    }
}