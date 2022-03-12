package com.flameshine.nebula

/**
 * Problem statement:
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */

fun main() {

    println(
        isPalindrome("A man, a plan, a canal: Panama")
    )
}

fun isPalindrome(s: String): Boolean {

    val result = s.filter { it.isLetterOrDigit() }
        .map { it.lowercaseChar() }

    return result == result.reversed()
}