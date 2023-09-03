package com.flameshine.nebula.problems.leetcode.archive

/**
 * Problem statement:
 *
 * You are given an integer array nums.
 * A number x is lonely when it appears only once, and no adjacent numbers (i.e. x + 1 and x - 1) appear in the array.
 * Return all lonely numbers in nums.
 * You may return the answer in any order.
 */

fun main() {

    val numbers = intArrayOf(10, 6, 5, 8)

    println(
        findLonely(numbers)
    )
}

fun findLonely(nums: IntArray): List<Int> {

    val numbersToFrequency = nums.asSequence()
        .groupingBy { it }
        .eachCount()

    return nums.filter { numbersToFrequency[it] == 1 && !numbersToFrequency.contains(it + 1) && !numbersToFrequency.containsKey(it - 1) }
        .toList()
}
