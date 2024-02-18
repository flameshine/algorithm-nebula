package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * №118 Pascal's Triangle
 *
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 */
public class PascalsTriangle {

    public static void main(String... args) {

        System.out.println(
            generate(5)
        );
    }

    /**
     * 1. Check if the number of rows is greater than zero and return empty list otherwise
     * 2. Add the first level of Pascal's triangle to the list, which always equal to 1
     * 3. Iterate over the number of rows and in each iteration:
     *    - add the left item which is always equal to 1
     *    - sum up items of the previous level
     *    - add 1 to the right
     *    - append the built level to the result and move on to the next one
     */
    private static List<List<Integer>> generate(int numRows) {

        if (numRows <= 0) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();

        result.add(List.of(1));

        for (var i = 1; i < numRows; i++) {

            var previous = result.get(i - 1);
            List<Integer> current = new ArrayList<>();

            current.add(1);

            for (var j = 1; j < previous.size(); j++) {
                current.add(
                    previous.get(j - 1) + previous.get(j)
                );
            }

            current.add(1);
            result.add(current);
        }

        return result;
    }
}