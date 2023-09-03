package com.flameshine.nebula.problems.leetcode.top_interview_150;

import java.util.Arrays;

/**
 * №88
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored.
 * nums2 has a length of n.
 */
public class MergeSortedArray {

    public static void main(String... args) {

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = { 2, 5, 6 };

        merge(nums1, 3, nums2, 3);

        System.out.println(
            Arrays.toString(nums1)
        );
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        var nums1Pointer = m - 1;
        var nums2Pointer = n - 1;
        var resultPointer = m + n - 1;

        while (nums2Pointer >= 0) {
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[resultPointer] = nums1[nums1Pointer--];
            } else {
                nums1[resultPointer] = nums2[nums2Pointer--];
            }
            --resultPointer;
        }
    }
}