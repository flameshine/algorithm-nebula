package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * №215 Kth Largest Element in an Array
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * Can you solve it without sorting?
 */
public class KthLargestElementInAnArray {

    public static void main(String... args) {

        var nums = new int[] { 3, 2, 1, 5, 6, 4 };

        System.out.println(
            findKthLargest(nums, 2)
        );
    }

    private static int findKthLargest(int[] nums, int k) {

        Queue<Integer> minHeap = new PriorityQueue<>();

        for (var i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (var i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}