package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * Given a string 's', reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */

fun main() {

    val s = "Let's take LeetCode contest"

    println(
        reverseWords(s)
    )
}

private fun reverseWords(s: String): String {

    val words = arrayListOf<String>()

    for (word in s.split(" ")) {

        words.add(
            reverseString(word)
        )
    }

    return words.joinToString(" ")
}

private fun reverseString(s: String): String {

    val characters = s.toCharArray()

    var start = 0
    var end = s.length - 1

    while (end > start) {
        val temporary = characters[start]
        characters[start] = characters[end]
        characters[end] = temporary
        ++start
        --end
    }

    return String(characters)
}