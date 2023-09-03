package com.flameshine.nebula.algorithms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String... args) {

        int[] array = { 5, 7, 3, 9, 8, 2, 1, 4, 6 };

        sort(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array applying the merge sort algorithm.
     *
     * 1. The base case is that the size of passed array is less or equal to 1.
     * 2. Divide an array into 2 parts.
     * 3. Recursively sort the left part and its sub-arrays.
     * 4. Recursively sort the right part and its sub-arrays.
     * 5. Call the merge function to aggregate sorted sub-results in the main array.
     */
    private static void sort(int[] array) {

        var length = array.length;

        if (length <= 1) {
            return;
        }

        var middle = length / 2;
        var left = new int[middle];
        var right = new int[length - middle];
        var i = 0;
        var j = 0;

        while (i < length) {
            if (i < middle) {
                left[i] = array[i];
            } else {
                right[j] = array[i];
                ++j;
            }
            ++i;
        }

        sort(left);
        sort(right);
        merge(left, right, array);
    }

    /**
     * Supportive function that merges two arrays.
     *
     * 1. Iterate over both arrays and determine which one has a lower value.
     * 2. Assign that value to the corresponding index in the main array.
     * 3. Iterate over leftover elements from the left array and add them to the main one.
     * 4. Iterate over leftover elements from the right array and add them to the main one.
     */
    private static void merge(int[] left, int[] right, int[] array) {

        var leftSize = array.length / 2;
        var rightSize = array.length - leftSize;
        var i = 0;
        var l = 0;
        var r = 0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                array[i] = left[l];
                ++l;
            } else {
                array[i] = right[r];
                ++r;
            }
            ++i;
        }

        while (l < leftSize) {
            array[i] = left[l];
            ++i;
            ++l;
        }

        while (r < rightSize) {
            array[i] = right[r];
            ++i;
            ++r;
        }
    }
}