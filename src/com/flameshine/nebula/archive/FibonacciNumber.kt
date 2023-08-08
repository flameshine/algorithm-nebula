package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * The Fibonacci numbers, commonly denoted F(n) from a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1.
 * Given n, calculate F(n).
 */

fun main() {

    println(
        fibonacci(4)
    )
}

fun fibonacci(n: Int): Int {
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}
