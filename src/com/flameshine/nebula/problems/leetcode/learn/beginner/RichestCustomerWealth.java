package com.flameshine.nebula.problems.leetcode.learn.beginner;

/**
 * №1672 Richest Customer Wealth
 *
 * You are given an m x n integer grid accounts where accounts[i][j] is the amount of money the i-th customer has in the j-th bank.
 * Return the wealth that the richest customer has.
 * A customer's wealth is the amount of money they have in all their bank accounts.
 * The richest customer is the customer that has the maximum wealth.
 */
public class RichestCustomerWealth {

    public static void main(String... args) {

        int[][] accounts = {
            { 1, 2, 3 },
            { 3, 2, 1 }
        };

        System.out.println(
            maximumWealth(accounts)
        );
    }

    private static int maximumWealth(int[][] accounts) {

        var max = Integer.MIN_VALUE;

        for (var customer : accounts) {
            var customerSum = 0;
            for (var bank : customer) {
                customerSum += bank;
            }
            max = Math.max(max, customerSum);
        }

        return max;
    }
}