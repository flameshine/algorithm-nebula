package com.flameshine.nebula.problems.leetcode.top_interview_150.matrix;

import java.util.LinkedList;
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

        List<Integer> result = new LinkedList<>();

        var left = 0;
        var right = matrix[0].length - 1;
        var top = 0;
        var bottom = matrix.length - 1;

        while (left <= right && top <= bottom) {

            for (var i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }

            ++top;

            for (var i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }

            --right;

            if (top <= bottom) {
                for (var i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                --bottom;
            }

            if (left <= right) {
                for (var i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                ++left;
            }
        }

        return result;
    }
}