package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.ArrayList;
import java.util.List;

/**
 * №119 Pascal's Triangle II
 *
 * Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown: <picture>.
 */
public class PascalsTriangle2 {

    public static void main(String... args) {
        System.out.println(
            getRow(4)
        );
    }

    private static List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>(rowIndex);

        row.add(1);

        var previous = 1;

        for (var i = 1; i <= rowIndex; ++i) {
            for (var j = 0; j < i - 1; ++j) {
                previous = row.set(j + 1, row.get(j + 1) + previous);
            }
            row.add(1);
        }

        return row;
    }
}