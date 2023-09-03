package com.flameshine.nebula.problems.leetcode.archive

/**
 * Problem statement:
 *
 * Given a string text, you want to use the characters of text to form as many instances of the word 'balloon' as possible.
 * You can use each character in text at most once.
 * Return the maximum number of instances that can be formed.
 */

fun main() {

    println(
        maxNumberOfBalloons("loonbalxballpoon")
    )
}

private fun maxNumberOfBalloons(text: String): Int {

    val charactersToCount = mutableMapOf('b' to 0, 'a' to 0, 'l' to 0, 'o' to 0, 'n' to 0)

    text.forEach {
        when (it) {
            'b', 'a', 'l', 'o', 'n' -> charactersToCount[it] = charactersToCount.getOrDefault(it, 0) + 1
        }
    }

    var result = 0

    while (charactersToCount.values.all { it > 0 }) {
        charactersToCount.forEach {
            when (it.key) {

                'b', 'a', 'n' -> {
                    if (it.value > 0) {
                        charactersToCount[it.key] = charactersToCount[it.key]!! - 1
                    } else {
                        return result
                    }
                }

                'l', 'o' -> {
                    if (it.value > 1) {
                        charactersToCount[it.key] = charactersToCount[it.key]!! - 2
                    } else {
                        return result
                    }
                }
            }
        }

        ++result
    }

    return result
}