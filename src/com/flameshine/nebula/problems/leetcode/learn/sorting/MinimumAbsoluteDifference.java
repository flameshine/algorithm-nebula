package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * №1200 Minimum Absolute Difference
 *
 * Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows:
 * - a, b are from arr
 * - a < b
 * - b - a equals to the minimum absolute difference of any two elements in arr
 */
public class MinimumAbsoluteDifference {

    public static void main(String... args) {

        var arr = new int[] { 4, 2, 1, 3 };

        System.out.println(
            minimumAbsDifference(arr)
        );
    }

    private static List<List<Integer>> minimumAbsDifference(int[] arr) {

        Arrays.sort(arr);

        var minimumDifference = Integer.MAX_VALUE;

        for (var i = 0; i < arr.length - 1; i++) {
            minimumDifference = Math.min(minimumDifference, arr[i + 1] - arr[i]);
        }

        List<List<Integer>> result = new ArrayList<>();

        for (var i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] == minimumDifference) {
                var pair = List.of(arr[i], arr[i + 1]);
                result.add(pair);
            }
        }

        return result;
    }
}