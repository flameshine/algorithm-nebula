package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * №54 Spiral Matrix
 *
 * Given an m x n matrix, return all elements of the matrix in spiral order.
 */
public class SpiralMatrix {

    public static void main(String... args) {

        int[][] matrix = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println(
            spiralOrder(matrix)
        );
    }

    private static List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> result = new ArrayList<>();

        var left = 0;
        var right = matrix[0].length - 1;
        var top = 0;
        var bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            for (var i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            ++top;

            for (var j = top; j <= bottom; j++) {
                result.add(matrix[j][right]);
            }

            --right;

            if (top <= bottom) {
                for (var i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                --bottom;
            }

            if (left <= right) {
                for (var j = bottom; j >= top; j--) {
                    result.add(matrix[j][left]);
                }
                ++left;
            }
        }

        return result;
    }
}