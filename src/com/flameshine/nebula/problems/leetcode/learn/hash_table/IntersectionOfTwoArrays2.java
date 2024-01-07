package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №350 Intersection of Two Arrays II
 *
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
public class IntersectionOfTwoArrays2 {

    public static void main(String... args) {

        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        System.out.println(
            Arrays.toString(
                intersect(nums1, nums2)
            )
        );
    }

    private static int[] intersect(int[] nums1, int[] nums2) {

        Map<Integer, Integer> numberToCount1 = new HashMap<>();
        for (var i : nums1) {
            numberToCount1.merge(i, 1, Integer::sum);
        }

        List<Integer> resultBuilder = new ArrayList<>();

        for (var i : nums2) {
            if (numberToCount1.containsKey(i) && numberToCount1.get(i) > 0) {
                resultBuilder.add(i);
                numberToCount1.merge(i, -1, Integer::sum);
            }
        }

        var result = new int[resultBuilder.size()];

        for (var i = 0; i < resultBuilder.size(); i++) {
            result[i] = resultBuilder.get(i);
        }

        return result;
    }
}