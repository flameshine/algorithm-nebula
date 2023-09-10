package com.flameshine.nebula.problems.leetcode.top_interview_150.intervals;

import java.util.LinkedList;
import java.util.List;

/**
 * №228 Summary Ranges
 *
 * You are given a sorted unique integer array nums.
 * A range [a,b] is the set of all integers from a to b (inclusive).
 * Return the smallest sorted list of ranges that cover all the numbers in the array exactly.
 * That is, each element of nums is covered by exactly one of the ranges, and there is no integer x such that x is in one of the ranges but not in nums.
 * Each range [a,b] in the list should be output as:
 *   - "a -> b" if a != b
 *   - "a" if a == b
 */
public class SummaryRanges {

    public static void main(String... args) {

        int[] nums = { 0, 1, 2, 4, 5, 7 };

        System.out.println(
            summaryRanges(nums)
        );
    }

    private static List<String> summaryRanges(int[] nums) {

        List<String> result = new LinkedList<>();

        var i = 0;
        var j = 0;

        while (i < nums.length) {

            if (j == nums.length - 1 || nums[j] + 1 != nums[j + 1]) {

                String range;
                if (i == j) {
                    range = String.valueOf(nums[j]);
                } else {
                    range = String.format("%d->%d", nums[i], nums[j]);
                }

                result.add(range);

                i = j + 1;
            }

            ++j;
        }

        return result;
    }
}