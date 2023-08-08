package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * Given the array of integers 'nums' and an integer 'target', return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */

fun main() {

    val numbers = intArrayOf(2, 7, 11, 15)

    println(
        twoSum(numbers, 9).contentToString()
    )
}

private fun twoSum(nums: IntArray, target: Int): IntArray {

    val indexMap = mutableMapOf<Int, Int>()

    for (i in nums.indices) {

        val desired = target - nums[i]

        indexMap[desired]?.let {
            return intArrayOf(it, i)
        }

        indexMap[nums[i]] = i
    }

    throw IllegalStateException("The problem should have at least one solution")
}