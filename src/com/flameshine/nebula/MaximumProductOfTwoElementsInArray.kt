package com.flameshine.nebula

import java.util.Arrays

/**
 * Problem statement:
 *
 * Given the array of integers, you will choose two different indices i and j of that array.
 * Return the maximum value of (numbers[i]) * (numbers[j]).
 */

fun main() {

    val numbers = intArrayOf(3, 4, 5, 2)

    println(
        maxProduct(numbers)
    )
}

fun maxProduct(numbers: IntArray): Int {

    Arrays.sort(numbers)

    return (numbers[numbers.size - 2]) * (numbers[numbers.size - 1])
}