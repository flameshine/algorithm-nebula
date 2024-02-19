package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Arrays;

/**
 * №88 Merge Sorted Array
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
 * To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
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

    /**
     * 1. Initialize the following variables:
     *    - the left pointer, which points to the end of the first array
     *    - the right pointer, which points to the end of the second array
     *    - index, which keeps track of the size of the resulting array
     * 2. Iterate while we have items in the second, smaller array
     * 3. With each iteration do the following:
     *    - if items in the left array are still present and item from the first array is greater than the right one, put an item from the left array
     *    - otherwise, put an item from the right array
     */
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        var left = m - 1;
        var right = n - 1;
        var index = m + n - 1;

        while (right >= 0) {
            if (left >= 0 && nums1[left] > nums2[right]) {
                nums1[index--] = nums1[left--];
            } else {
                nums1[index--] = nums2[right--];
            }
        }
    }
}