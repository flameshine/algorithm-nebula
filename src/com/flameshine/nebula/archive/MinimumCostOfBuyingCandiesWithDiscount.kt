package com.flameshine.nebula.archive

/**
 * Problem statement:
 *
 * A shop is selling candies at a discount.
 * For every two candies sold, the shop gives a third candy for free.
 * The customer can choose any candy to take away for free as long as the cost of the chosen candy is less than or equal to the minimum cost of the two candies bought.
 * For example, if there are 4 candies with costs 1, 2, 3 and 4, the customer buys candies with costs 2 and 3, they can take the candy with cost 1 for free, but not the candy with cost 4.
 * Given a 0-indexed integer array cost, where cost[i] denotes the cost of the i-th candy, return the minimum cost of buying all the candies.
 */

fun main() {

    println(
        minimumCost(
            intArrayOf(10, 5, 9, 4, 1, 9, 10, 2, 10, 8)
        )
    )
}

private fun minimumCost(cost: IntArray): Int {

    cost.sortDescending()

    var result = 0

    for (i in 1..cost.size) {

        if (i % 3 == 0) {
            continue
        }

        result += cost[i - 1]
    }

    return result
}