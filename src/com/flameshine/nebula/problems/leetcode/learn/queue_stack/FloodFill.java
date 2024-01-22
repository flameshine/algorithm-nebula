package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.Arrays;

/**
 * №733 Flood Fill
 *
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 * You are also given three integers sr, sc, and color.
 * You should perform a flood fill on the image starting from the pixel image[sr][sc].
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on.
 * Replace the color of all the aforementioned pixels with color.
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {

    public static void main(String... args) {

        var image = new int[][] {
            { 1, 1, 1 },
            { 1, 1, 0 },
            { 1, 0, 1 }
        };

        System.out.println(
            Arrays.deepToString(
                floodFill(image, 1, 1, 2)
            )
        );
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        var startingColor = image[sr][sc];
        fillAdjacent(image, sr, sc, startingColor, color);
        return image;
    }

    private static void fillAdjacent(int[][] image, int sr, int sc, int startingColor, int color) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sr].length || image[sr][sc] != startingColor || image[sr][sc] == color) {
            return;
        }

        image[sr][sc] = color;

        fillAdjacent(image, sr + 1, sc, startingColor, color);
        fillAdjacent(image, sr - 1, sc, startingColor, color);
        fillAdjacent(image, sr, sc + 1, startingColor, color);
        fillAdjacent(image, sr, sc -1, startingColor, color);
    }
}