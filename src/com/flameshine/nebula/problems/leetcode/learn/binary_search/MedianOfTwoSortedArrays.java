package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №4 Median of Two Sorted Arrays
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 * The overall run time complexity should be O(log(m + n)).
 */
public class MedianOfTwoSortedArrays {

    public static void main(String... args) {

        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };

        System.out.println(
            findMedianSortedArrays(nums1, nums2)
        );
    }

    private static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        var merged = new int[nums1.length + nums2.length];
        var counter = 0;
        var i = 0;
        var j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                merged[counter++] = nums1[i++];
            } else {
                merged[counter++] = nums2[j++];
            }
        }

        while (i < nums1.length) {
            merged[counter++] = nums1[i++];
        }

        while (j < nums2.length) {
            merged[counter++] = nums2[j++];
        }

        if ((merged.length & 1) == 0) {
            return (merged[merged.length / 2] + merged[merged.length / 2 - 1]) / 2d;
        }

        return merged[merged.length / 2];
    }
}