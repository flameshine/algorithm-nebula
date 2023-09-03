package com.flameshine.nebula.problems.leetcode.archive

import kotlin.math.abs

/**
 * Two strings word1 and word2 are considered almost equivalent if the differences between the frequencies of each letter from 'a' to 'z' between word1 and word2 is at most 3.
 * Given two strings word1 and word2, each of length n, return true if word1 and word2 are almost equivalent, or false otherwise.
 * The frequency of a letter x is the number of times it occurs in the string.
 */

fun main() {

    println(
        checkAlmostEquivalent("abcdeef", "abaaacc")
    )
}

private fun checkAlmostEquivalent(word1: String, word2: String): Boolean {

    val word1Frequencies = HashMap<Char, Int>()
    val word2Frequencies = HashMap<Char, Int>()

    for (i in word1.indices) {
        word1Frequencies.merge(word1[i], 1, Int::plus)
        word2Frequencies.merge(word2[i], 1, Int::plus)
    }

    for (entry in word1Frequencies.entries) {

        val word2Frequency = word2Frequencies.getOrDefault(entry.key, 0)

        if (abs(word2Frequency.minus(entry.value)) > 3) return false
    }

    for (entry in word2Frequencies.entries) {

        val word1Frequency = word1Frequencies.getOrDefault(entry.key, 0)

        if (abs(word1Frequency.minus(entry.value)) > 3) return false
    }

    return true
}