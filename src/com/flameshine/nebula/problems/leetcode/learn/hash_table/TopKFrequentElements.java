package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * №347 Top K Frequent Elements
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
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

        Map<Integer, Integer> numberFrequencies = new HashMap<>();

        for (var n : nums) {
            numberFrequencies.merge(n, 1, Integer::sum);
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Map.Entry.comparingByValue());

        for (var e : numberFrequencies.entrySet()) {
            if (queue.size() == k && queue.peek().getValue() < e.getValue()) {
                queue.remove();
            }
            if (queue.size() < k) {
                queue.add(e);
            }
        }

        var result = new int[k];

        for (var i = 0; i < k; i++) {
            result[i] = queue.poll().getKey();
        }

        return result;
    }
}