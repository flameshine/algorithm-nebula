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