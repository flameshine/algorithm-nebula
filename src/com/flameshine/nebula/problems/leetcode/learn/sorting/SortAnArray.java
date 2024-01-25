package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.Arrays;
import java.util.Random;

/**
 * №912 Sort an Array
 *
 * Given an array of integers nums, sort the array in ascending order and return it.
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 */
public class SortAnArray {

    public static void main(String... args) {

        var nums = new int[] { 5, 2, 3, 1 };

        System.out.println(
            Arrays.toString(
                sortArray(nums)
            )
        );
    }

    private static int[] sortArray(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private static void quickSort(int[] nums, int start, int end) {

        if (start >= end) {
            return;
        }

        var lowerBoundary = start;
        var higherBoundary = end;
        var pivot = nums[start];
        var i = start;

        while (i <= higherBoundary) {
            if (nums[i] < pivot) {
                swap(nums, lowerBoundary++, i++);
            } else if (nums[i] > pivot) {
                swap(nums, i, higherBoundary--);
            } else {
                ++i;
            }
        }

        quickSort(nums, start, lowerBoundary - 1);
        quickSort(nums, higherBoundary + 1, end);
    }

    private static void swap(int[] nums, int i, int j) {
        var tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private static void shuffle(int[] array) {

        var random = new Random();

        int index;

        for (int i = array.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            if (index != i) {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }
}