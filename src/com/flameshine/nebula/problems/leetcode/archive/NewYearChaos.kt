package com.flameshine.nebula.problems.leetcode.archive

/**
 * Problem statement:
 *
 * It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride!
 * There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue.
 * Initial positions increment by 1 from 1 at the front of the line to at the back.
 * Any person in the queue can bribe the person directly in front of them to swap positions.
 * If two people swap positions, they still wear the same sticker denoting their original places in line.
 * One person can bribe at most two others.
 * For example, if n = 8 and person 5 bribes person 4, the queue will look like this: 1, 2, 3, 5, 4, 6, 7, 8.
 * Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!
 *
 * Function description:
 *
 * Complete the function minimumBribes in the editor below.
 * It must print an integer representing the minimum number of bribes necessary, or "Too chaotic" if the line configuration is not possible.
 * The function has the following parameter(s): numbers - an array of integers.
 *
 * Output format:
 *
 * Print an integer denoting the minimum number of bribes needed to get the queue into its final state.
 * Print "Too chaotic" if the state is invalid, i.e. it requires a person to have bribed more than 2 people.
 */

fun main() {

    val numbers = intArrayOf(2, 1, 3, 5, 4, 6, 8, 7)

    println(
        minimumBribes(numbers)
    )
}

private fun minimumBribes(numbers: IntArray): Int {

    var result = 0

    for (i in numbers.indices) {

        val distanceToInitialPosition = numbers[i] - (i + 1)

        check(distanceToInitialPosition <= 2) { "Too chaotic" }

        for (j in 0.coerceAtLeast(numbers[i] - 2) until i) {
            if (numbers[j] > numbers[i]) {
                ++result
            }
        }
    }

    return result
}