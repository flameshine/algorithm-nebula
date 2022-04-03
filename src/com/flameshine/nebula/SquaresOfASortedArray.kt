package com.flameshine.nebula

/**
 * Problem statement:
 *
 * Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
 */

fun main() {

    println(
        sortedSquares(
            intArrayOf(-4, -1, 0, 3, 10)
        ).contentToString()
    )
}

private fun sortedSquares(nums: IntArray): IntArray {
    return nums.map { it * it }
        .sorted()
        .toIntArray()
}