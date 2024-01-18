package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

/**
 * №200 Number of Islands
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {

    public static void main(String... args) {

        var grid = new char[][] {
            { '1', '1', '1', '1', '0' },
            { '1', '1', '0', '1', '0' },
            { '1', '1', '0', '0', '0' },
            { '0', '0', '0', '0', '0' }
        };

        System.out.println(
            numIslands(grid)
        );
    }

    private static int numIslands(char[][] grid) {

        var count = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++count;
                    clearRestOfTheLand(grid, i, j);
                }
            }
        }

        return count;
    }

    private static void clearRestOfTheLand(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        clearRestOfTheLand(grid, i + 1, j);
        clearRestOfTheLand(grid, i - 1, j);
        clearRestOfTheLand(grid, i, j + 1);
        clearRestOfTheLand(grid, i, j - 1);
    }
}