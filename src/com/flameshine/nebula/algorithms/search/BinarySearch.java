package com.flameshine.nebula.algorithms.search;

/**
 * Implementation of the binary search algorithm.
 * Complexity: time - O(n * log(n)), space - O(1) (for iterative implementation).
 */
public class BinarySearch {

    public static void main(String... args) {

        var array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        System.out.println(
            search(array, 1)
        );

        System.out.println(
            search(array, 5)
        );

        System.out.println(
            search(array, 10)
        );
    }

    /**
     * Searches for an element in the sorted array using the binary search algorithm.
     *
     * 1. With each iteration, divide an array by half, based for the following conditions:
     *    - if the element in the middle is greater than the target, set the boundaries to the left half of the array
     *    - if the element in the middle is lower than the target, set the boundaries to the right half of the array
     *    - if the element is equal, save in index and exit from the loop
     * 2. Return the index of an element if it was found, or -1 otherwise.
     */
    private static int search(int[] array, int target) {

        var start = 0;
        var end = array.length - 1;

        while (start <= end) {
            var middle = (start + end) / 2;
            if (array[middle] < target) {
                start = middle + 1;
            } else if (array[middle] > target) {
                end = middle - 1;
            } else {
                return middle;
            }
        }

        return -1;
    }
}