package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * №454 4Sum II
 *
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n, return the number of tuples (i, j, k, l) such that:
 * -  0 <= i, j, k, l < n
 * -  nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class FourSum2 {

    public static void main(String... args) {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };

        System.out.println(
            fourSumCount(nums1, nums2, nums3, nums4)
        );
    }

    private static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {

        Map<Integer, Integer> map = new HashMap<>();

        for (var k : nums3) {
            for (var l : nums4) {
                map.merge(k + l, 1, Integer::sum);
            }
        }

        var count = 0;

        for (var i : nums1) {
            for (var j : nums2) {
                count += map.getOrDefault(-(i + j), 0);
            }
        }

        return count;
    }
}