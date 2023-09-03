package com.flameshine.nebula.problems.leetcode.archive

/**
 * Problem statement:
 *
 * You are given a 0-indexed integer array 'nums'.
 * You are also given an integer 'key', which is present in 'nums'.
 * For every unique integer 'target' in 'nums', count the number of times 'target' immediately follows an occurrence of 'key' in 'nums'.
 * Return the 'target' with maximum count.
 */

fun main() {

    val nums = intArrayOf(1, 100, 200, 1, 100)

    println(
        mostFrequent(nums, 1)
    )
}

fun mostFrequent(nums: IntArray, key: Int): Int {

    val targetToFrequency = HashMap<Int, Int>()

    for (i in 0..nums.size - 2) {
        if (nums[i] == key) {
            targetToFrequency.merge(nums[i + 1], 1, Integer::sum)
        }
    }

    return targetToFrequency.maxByOrNull { it.value }!!.key
}