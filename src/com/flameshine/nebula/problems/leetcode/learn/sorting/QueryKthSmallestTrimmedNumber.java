package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.Arrays;

/**
 * №2343 Query Kth Smallest Trimmed Number
 *
 * You are given a 0-indexed array of strings nums, where each string is of equal length and consists of only digits.
 * You are also given a 0-indexed 2D integer array queries where queries[i] = [ki, trimi].
 * For each queries[i], you need to:
 * - Trim each number in nums to its rightmost trim[i] digits.
 * - Determine the index of the k[i]th smallest trimmed number in nums.
 *   If two trimmed numbers are equal, the number with the lower index is considered to be smaller.
 * - Reset each number in nums to its original length.
 * Return an array answer of the same length as queries, where answer[i] is the answer to the ith query.
 * Note:
 * - To trim to the rightmost x digits means to keep removing the leftmost digit, until only x digits remain.
 * - Strings in nums may contain leading zeros.
 */
public class QueryKthSmallestTrimmedNumber {

    public static void main(String... args) {

        var nums = new String[] { "102", "473", "251", "814" };

        var queries = new int[][] {
            { 1, 2 },
            { 2, 3 },
            { 4, 2 },
            { 1, 2 }
        };

        System.out.println(
            Arrays.toString(
                smallestTrimmedNumbers(nums, queries)
            )
        );
    }

    private static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {

        var unsorted = new Pair[nums.length];

        for (var i = 0; i < nums.length; i++) {
            unsorted[i] = new Pair(nums[i], i);
        }

        var digit = nums[0].length() - 1;
        var result = new int[queries.length];
        var i = 0;

        while (digit >= 0 && i < queries.length) {
            unsorted = countingSort(unsorted, digit);
            var j = 0;
            for (var query : queries) {
                if (nums[0].length() - query[1] == digit) {
                    result[j] = unsorted[query[0] - 1].index;
                    ++i;
                }
                ++j;
            }
            --digit;
        }

        return result;
    }

    private static Pair[] countingSort(Pair[] unsorted, int digit) {

        var buckets = new int[10];

        for (var i : unsorted) {
            buckets[i.value().charAt(digit) - '0']++;
        }

        for (var i = 1; i < buckets.length; i++) {
            buckets[i] += buckets[i - 1];
        }

        var sorted = new Pair[unsorted.length];

        for (var i = unsorted.length - 1; i >= 0; i--) {
            sorted[--buckets[unsorted[i].value().charAt(digit) - '0']] = unsorted[i];
        }

        return sorted;
    }

    private record Pair(String value, int index) { }
}