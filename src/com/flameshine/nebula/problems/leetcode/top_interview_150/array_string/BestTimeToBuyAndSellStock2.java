package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №122 Best Time to Buy and Sell Stock II
 *
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock.
 * You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 */
public class BestTimeToBuyAndSellStock2 {

    public static void main(String... args) {

        int[] prices = { 1, 2, 3, 4, 5 };

        System.out.println(
            maxProfit(prices)
        );
    }

    private static int maxProfit(int[] prices) {

        if (prices.length <= 1) {
            return 0;
        }

        var profit = 0;

        for (var i = 1; i < prices.length; i++) {
            profit += Math.max(0, prices[i] - prices[i - 1]);
        }

        return profit;
    }
}