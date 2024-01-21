package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.Stack;

/**
 * №150 Evaluate Reverse Polish Notation
 *
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * Evaluate the expression.
 * Return an integer that represents the value of the expression.
 *
 * Note that:
 *
 * - The valid operators are '+', '-', '*', and '/'.
 * - Each operand may be an integer or another expression.
 * - The division between two integers always truncates toward zero.
 * - There will not be any division by zero.
 * - The input represents a valid arithmetic expression in a reverse polish notation.
 * - The answer and all the intermediate calculations can be represented in a 32-bit integer.
 */
public class EvaluateReversePolishNotation {

    public static void main(String... args) {

        var tokens = new String[] { "2", "1", "+", "3", "*" };

        System.out.println(
            evalRPN(tokens)
        );
    }

    private static int evalRPN(String[] tokens) {

        Stack<String> stack = new Stack<>();

        var x = "-1";

        for (var token : tokens) {

            switch (token) {
                case "+" -> x = Integer.toString(Integer.parseInt(stack.pop()) + Integer.parseInt(stack.pop()));
                case "-" -> {
                    var y = stack.pop();
                    x = Integer.toString(Integer.parseInt(stack.pop()) - Integer.parseInt(y));
                }
                case "*" -> x = Integer.toString(Integer.parseInt(stack.pop()) * Integer.parseInt(stack.pop()));
                case "/" -> {
                    var y = stack.pop();
                    x = Integer.toString(Integer.parseInt(stack.pop()) / Integer.parseInt(y));
                }
                default -> x = token;
            }

            stack.push(x);
        }

        return Integer.parseInt(x);
    }
}