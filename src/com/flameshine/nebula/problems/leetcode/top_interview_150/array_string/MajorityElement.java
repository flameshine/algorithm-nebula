package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

import java.util.HashMap;
import java.util.Map;

/**
 * №169 Majority Element
 *
 * Given an array nums of size n, return the majority element.
 * The majority element is the element that appears more than ⌊n / 2⌋ times.
 * You may assume that the majority element always exists in the array.
 */
public class MajorityElement {

    public static void main(String... args) {

        int[] nums = { 3, 2, 3 };

        System.out.println(
            majorityElement(nums)
        );
    }

    private static int majorityElement(int[] nums) {

        Map<Integer, Integer> numbersToFrequency = new HashMap<>();

        for (int num : nums) {
            numbersToFrequency.merge(num, 1, Integer::sum);
            if (numbersToFrequency.get(num) > nums.length / 2) {
                return num;
            }
        }

        return -1;
    }
}