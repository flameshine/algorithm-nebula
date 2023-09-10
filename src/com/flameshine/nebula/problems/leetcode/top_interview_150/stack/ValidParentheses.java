package com.flameshine.nebula.problems.leetcode.top_interview_150.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * №20 Valid Parentheses
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 *   - Open brackets must be closed by the same type of brackets.
 *   - Open brackets must be closed in the correct order.
 *   - Every close bracket has a corresponding open bracket of the same type.
 */
public class ValidParentheses {

    public static void main(String... args) {
        System.out.println(
            isValid("[]")
        );
    }

    private static boolean isValid(String s) {

        Deque<Character> brackets = new LinkedList<>();

        for (var c : s.toCharArray()) {
            switch (c) {
                case '(' -> brackets.push(')');
                case '[' -> brackets.push(']');
                case '{' -> brackets.push('}');
                default -> {
                    if (brackets.isEmpty() || brackets.pop() != c) {
                        return false;
                    }
                }
            }
        }

        return brackets.isEmpty();
    }
}