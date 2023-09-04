package com.flameshine.nebula.problems.leetcode.top_interview_150.two_pointers;

/**
 * №11 Container With Most Water
 *
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 * Return the maximum amount of water a container can store.
 * Notice that you may not slant the container.
 */
public class ContainerWithMostWater {

    public static void main(String... args) {

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println(
            maxArea(height)
        );
    }

    private static int maxArea(int[] height) {

        var max = Integer.MIN_VALUE;
        var left = 0;
        var right = height.length - 1;

        while (left < right) {
            var current = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, current);
            if (height[left] < height[right]) {
                ++left;
            } else {
                --right;
            }
        }

        return max;
    }
}