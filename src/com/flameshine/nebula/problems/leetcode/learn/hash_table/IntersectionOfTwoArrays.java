package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * №349 Intersection of Two Arrays
 *
 * iven two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must be unique and you may return the result in any order.
 */
public class IntersectionOfTwoArrays {

    public static void main(String... args) {

        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        System.out.println(
            Arrays.toString(
                intersection(nums1, nums2)
            )
        );
    }

    private static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> unique1 = new HashSet<>();

        for (var n : nums1) {
            unique1.add(n);
        }

        Set<Integer> intersection = new HashSet<>();

        for (var n : nums2) {
            if (unique1.contains(n)) {
                intersection.add(n);
            }
        }

        var result = new int[intersection.size()];
        var i = 0;

        for (var n : intersection) {
            result[i++] = n;
        }

        return result;
    }
}