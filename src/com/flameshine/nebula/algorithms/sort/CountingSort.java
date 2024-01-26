package com.flameshine.nebula.algorithms.sort;

import java.util.Arrays;

/**
 * Implementation of the counting sort algorithm.
 * Complexity: time - O(n + k), space - O(k).
 */
public class CountingSort {

    public static void main(String... args) {

        int[] array = { 1, 0, 3, 1, 3, 1 };

        sort(array);

        System.out.println(
            Arrays.toString(array)
        );
    }

    /**
     * Sorts an array using the counting sort algorithm.
     *
     * 1. Find the maximum element in the array.
     * 2. Find the number of occurrences of each element.
     * 3. Shift all values to the right, finding the starting indices.
     * 4. Place elements on their starting indices.
     *    We should increment the index with each iteration so the next element is places in appropriate index.
     * 5. Copy the result to the destination array.
     */
    private static void sort(int[] array) {

        var k = Integer.MIN_VALUE;

        for (var i : array) {
            k = Math.max(k, i);
        }

        var counts = new int[k + 1];

        for (var i : array) {
            counts[i] += 1;
        }

        var startingIndex = 0;

        for (var i = 0; i < counts.length; i++) {
            var count = counts[i];
            counts[i] = startingIndex;
            startingIndex += count;
        }

        var sorted = new int[array.length];

        for (var i : array) {
            sorted[counts[i]] = i;
            counts[i] += 1;
        }

        System.arraycopy(sorted, 0, array, 0, sorted.length);
    }
}