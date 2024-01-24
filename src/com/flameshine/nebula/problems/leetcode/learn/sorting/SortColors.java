package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.Arrays;

/**
 * №75 Sort Colors
 *
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 */
public class SortColors {

    public static void main(String... args) {

        var nums = new int[] { 2, 0, 2, 1, 1, 0 };

        sortColors(nums);

        System.out.println(
            Arrays.toString(nums)
        );
    }

    private static void sortColors(int[] nums) {
        mergeSort(nums);
    }

    private static void mergeSort(int[] array) {

        if (array.length <= 1) {
            return;
        }

        var middle = array.length / 2;
        var left = new int[middle];
        var right = new int[array.length - middle];

        System.arraycopy(array, 0, left, 0, middle);
        System.arraycopy(array, middle, right, 0, array.length - middle);

        mergeSort(left);
        mergeSort(right);
        merge(left, right, array);
    }

    private static void merge(int[] left, int[] right, int[] array) {

        var leftSize = array.length / 2;
        var rightSize = array.length - leftSize;
        var i = 0;
        var l = 0;
        var r = 0;

        while (l < leftSize && r < rightSize) {
            if (left[l] < right[r]) {
                array[i] = left[l++];
            } else {
                array[i] = right[r++];
            }
            ++i;
        }

        while (l < leftSize) {
            array[i++] = left[l++];
        }

        while (r < rightSize) {
            array[i++] = right[r++];
        }
    }
}