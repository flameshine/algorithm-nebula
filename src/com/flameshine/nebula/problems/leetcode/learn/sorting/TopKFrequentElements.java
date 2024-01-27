package com.flameshine.nebula.problems.leetcode.learn.sorting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * №347 Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
public class TopKFrequentElements {

    public static void main(String... args) {

        var nums = new int[] { 1, 1, 1, 2, 2, 3 };

        System.out.println(
            Arrays.toString(
                topKFrequent(nums, 2)
            )
        );
    }

    private static int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> numberFrequency = new HashMap<>();

        for (var i : nums) {
            numberFrequency.merge(i, 1, Integer::sum);
        }

        Queue<Integer> heap = new PriorityQueue<>((a, b) -> numberFrequency.get(b) - numberFrequency.get(a));

        heap.addAll(numberFrequency.keySet());

        var result = new int[k];

        for (var i = 0; i < k; i++) {
            result[i] = Objects.requireNonNull(heap.poll());
        }

        return result;
    }
}