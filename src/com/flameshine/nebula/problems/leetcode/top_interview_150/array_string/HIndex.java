package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

import java.util.Arrays;

/**
 * №274 H-Index
 *
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 */
public class HIndex {

    public static void main(String... args) {

        int[] nums = { 3, 0, 6, 1, 5 };

        System.out.println(
            hIndex(nums)
        );
    }

    private static int hIndex(int[] citations) {

        Arrays.sort(citations);

        var current = 1;

        while (current <= citations.length) {
            if (citations[citations.length - current] < current) {
                break;
            }
            ++current;
        }

        return current - 1;
    }
}