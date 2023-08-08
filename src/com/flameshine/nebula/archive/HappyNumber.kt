package com.flameshine.nebula.archive

/**
 * Write an algorithm to determine if a number n is happy.
 * A happy number is a number defined by the following process:
 *  - Starting with any positive integer, replace the number by the sum of the squares of its digits
 *  - Repeat the process until the number equals 1 (where it will say), or it loops endlessly in a cycle which does not include 1
 *  - Those numbers for which this process ends in 1 are happy
 *  Return true if n is a happy number and false if not.
 */

fun main() {

    println(
        isHappy(19)
    )
}

private fun isHappy(n: Int): Boolean = isHappyWithMemory(n, HashSet())

private fun isHappyWithMemory(n: Int, memory: HashSet<Int>): Boolean {

    if (memory.contains(n)) return false

    memory.add(n)

    val stringified = n.toString()

    return when (val sumOfDigits = List(stringified.length) { powInt(stringified[it].digitToInt()) }.sum()) {
        1 -> true
        else -> {
            isHappyWithMemory(sumOfDigits, memory)
        }
    }
}

private fun powInt(n: Int): Int = n * n