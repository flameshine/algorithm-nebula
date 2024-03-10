package com.flameshine.nebula.problems.leetcode.learn.binary_search;

import java.util.ArrayList;
import java.util.List;

/**
 * №658 Find K Closest Elements
 *
 * Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array.
 * The result should also be sorted in ascending order.
 * An integer a is closer to x than an integer b if:
 * - |a - x| < |b - x|, or
 * - |a - x| == |b - x| and a < b
 */
public class FindKClosestElements {

    public static void main(String... args) {

        int[] nums = { 1, 2, 3, 4, 5 };

        System.out.println(
            findClosestElements(nums, 4, 3)
        );
    }

    private static List<Integer> findClosestElements(int[] arr, int k, int x) {

        var left = 0;
        var right = arr.length - k;

        while (left < right) {
            var middle = left + (right - left) / 2;
            if (x - arr[middle] > arr[middle + k] - x) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }

        List<Integer> result = new ArrayList<>();

        for (var i = left; i < left + k; i++) {
            result.add(arr[i]);
        }

        return result;
    }
}