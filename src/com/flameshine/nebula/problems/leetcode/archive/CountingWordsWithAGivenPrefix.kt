package com.flameshine.nebula.problems.leetcode.archive

/**
 * Problem statement:
 *
 * You're given an array of strings words and a string pref.
 * Return the number of strings in words that contain pref as a prefix.
 * A prefix of a string s is any leading contiguous substring of s.
 */

fun main() {

    val numbers = arrayOf("pay", "attention", "practice", "attend")

    println(
        prefixCount(numbers, "at")
    )
}

private fun prefixCount(words: Array<String>, pref: String): Int {

    var counter = 0

    for (word in words) {

        if (word.startsWith(pref)) {
            ++counter
        }
    }

    return counter
}