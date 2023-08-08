package com.flameshine.nebula.archive

/**
 * Given an integer array nums, return the number of elements that have both a strictly smaller and a strictly greater element appear in nums.
 */

fun main() {

    val nums = intArrayOf(-65, -65, 50, -65, 50, -55, -65, -65)

    println(
        countElements(nums)
    )
}

private fun countElements(nums: IntArray): Int {

    nums.sort()

    return nums.count { it != nums[0] && it != nums[nums.size - 1]}
}