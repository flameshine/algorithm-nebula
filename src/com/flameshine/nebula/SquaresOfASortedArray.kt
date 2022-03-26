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
    return nums.map { square(it) }
        .sorted()
        .toIntArray()
}

private fun square(n: Int): Int {
    return n * n
}