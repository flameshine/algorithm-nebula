package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return index.
 * Otherwise, return -1.
 */

fun main() {

    val numbers = intArrayOf(-1, 0, 3, 5, 9, 12)

    println(
        search(numbers, 5)
    )
}

private fun search(nums: IntArray, target: Int): Int {
    return binarySearch(nums, 0, nums.size, target)
}

private fun binarySearch(nums: IntArray, leftIndex: Int, rightIndex: Int, target: Int): Int {

    if (leftIndex >= rightIndex) return -1

    val middleIndex = (leftIndex + rightIndex) / 2

    return when {
        nums[middleIndex] > target -> binarySearch(nums, 0, middleIndex, target)
        nums[middleIndex] < target -> binarySearch(nums, middleIndex + 1, rightIndex, target)
        else -> middleIndex
    }
}