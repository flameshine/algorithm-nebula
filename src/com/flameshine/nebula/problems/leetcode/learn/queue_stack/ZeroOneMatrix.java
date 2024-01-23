package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * №542 01 Matrix
 *
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 */
public class ZeroOneMatrix {

    public static void main(String... args) {

        var mat = new int[][] {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 }
        };

        System.out.println(
            Arrays.deepToString(
                updateMatrix(mat)
            )
        );
    }

    private static int[][] updateMatrix(int[][] mat) {

        var m = mat.length;
        var n = mat[0].length;
        var distances = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for (var i = 0; i < mat.length; i++) {
            for (var j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        var directions = new int[][] {
            { 1, 0 },
            { 0, 1 },
            { -1, 0 },
            { 0, -1 }
        };

        while (!queue.isEmpty()) {
            var current = queue.poll();
            var row = current[0];
            var col = current[1];
            for (var d : directions) {
                var r = row + d[0];
                var c = col + d[1];
                if (r >= 0 && r < m && c >= 0 && c < n && distances[r][c] > distances[row][col] + 1) {
                    distances[r][c] = distances[row][col] + 1;
                    queue.offer(
                        new int[] { r, c }
                    );
                }
            }
        }

        return distances;
    }
}