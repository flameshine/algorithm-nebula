package com.flameshine.nebula

/**
 * Problem statement:
 *
 * Given a sorted array of distinct integers and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 */

fun main() {

    val numbers = intArrayOf(1, 3, 5, 6)

    println(
        searchInsert(numbers, 7)
    )
}

private fun searchInsert(nums: IntArray, target: Int): Int {

    if (target <= nums[0]) return 0

    for (i in nums.indices) {
        if (i == nums.size - 1 || (nums[i] <= target && nums[i + 1] >= target)) {
            return i + 1
        }
    }

    throw IllegalStateException("The problem should have at least one solution")
}