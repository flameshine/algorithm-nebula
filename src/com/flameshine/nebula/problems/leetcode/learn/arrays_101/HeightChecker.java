package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №1051 Height Checker
 *
 * A school is trying to take an annual photo of all the students.
 * The students are asked to stand in a single file line in non-decreasing order by height.
 * Let this ordering be represented by the integer array expected where expected[i] is the expected height of the ith student in line.
 * You are given an integer array heights representing the current order that the students are standing in.
 * Each heights[i] is the height of the ith student in line (0-indexed).
 * Return the number of indices where heights[i] != expected[i].
 */
public class HeightChecker {

    public static void main(String... args) {

        int[] heights = { 1, 1, 4, 2, 1, 3 };

        System.out.println(
            heightChecker(heights)
        );
    }

    private static int heightChecker(int[] heights) {

        var expected = new int[heights.length];

        System.arraycopy(heights, 0, expected, 0, heights.length);

        Arrays.sort(expected);

        var result = 0;

        for (var i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                ++result;
            }
        }

        return result;
    }
}