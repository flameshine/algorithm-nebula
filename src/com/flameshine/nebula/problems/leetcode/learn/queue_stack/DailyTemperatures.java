package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * №739 Daily Temperatures
 *
 * Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature.
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
public class DailyTemperatures {

    public static void main(String... args) {

        var temperatures = new int[] { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(
            Arrays.toString(
                dailyTemperatures(temperatures)
            )
        );
    }

    private static int[] dailyTemperatures(int[] temperatures) {

        var result = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();

        for (var i = temperatures.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return result;
    }
}