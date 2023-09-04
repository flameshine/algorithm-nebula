package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №121 Best Time to Buy and Sell Stock
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction.
 * If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyAndSellStock {

    public static void main(String... args) {

        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println(
            maxProfit(prices)
        );
    }

    private static int maxProfit(int[] prices) {

        var min = Integer.MAX_VALUE;
        var max = 0;

        for (var price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }

        return max;
    }
}