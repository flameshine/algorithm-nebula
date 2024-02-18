package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.Arrays;

/**
 * №498 Diagonal Traverse
 *
 * Given an m x n matrix mat, return an array of all the elements of the array in a diagonal order.
 */
public class DiagonalTraverse {

    public static void main(String... args) {

        int[][] mat = {
            { 1, 2, 3 },
            { 4, 5, 6 },
            { 7, 8, 9 }
        };

        System.out.println(
            Arrays.toString(
                findDiagonalOrder(mat)
            )
        );
    }

    /**
     * 1. Validate that the matrix isn't empty and initialize all values, such as a resulting matrix and diagonal directions
     * 2. Move diagonally, changing the direction if we're crossing the matrix "border"
     */
    private static int[] findDiagonalOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }

        var m = matrix.length;
        var n = matrix[0].length;
        var result = new int[m * n];
        var row = 0;
        var col = 0;
        var d = 0;

        var directions = new int[][] {
            { -1, 1 },
            { 1, -1 }
        };

        for (var i = 0; i < m * n; i++) {

            result[i] = matrix[row][col];
            row += directions[d][0];
            col += directions[d][1];

            if (row >= m) {
                row = m - 1;
                col += 2;
                d = 1 - d;
            }

            if (col >= n) {
                col = n - 1;
                row += 2;
                d = 1 - d;
            }

            if (row < 0) {
                row = 0;
                d = 1 - d;
            }

            if (col < 0) {
                col = 0;
                d = 1 - d;
            }
        }

        return result;
    }
}