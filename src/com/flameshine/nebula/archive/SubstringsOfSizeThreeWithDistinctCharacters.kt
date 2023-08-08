package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * A string is good if there are no repeated characters.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a continuous sequence of characters in a string.
 */

fun main() {

    println(
        countGoodSubstrings("xyzzaz")
    )
}

private fun countGoodSubstrings(s: String): Int {

    val substringLength = 3

    var result = 0

    for (i in s.indices) {

        val endIndex = i + substringLength

        if (endIndex <= s.length && substringLength == s.substring(i, endIndex).chars().distinct().count().toInt()) {
            ++result
        }
    }

    return result
}