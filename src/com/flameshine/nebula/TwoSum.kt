package com.flameshine.nebula

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

fun twoSum(nums: IntArray, target: Int): IntArray {

    for (i in nums.indices) {
        for (j in nums.indices) {
            if (i != j && nums[i] + nums[j] == target) {
                return intArrayOf(i, j)
            }
        }
    }

    throw IllegalStateException("The problem should have at least one solution")
}