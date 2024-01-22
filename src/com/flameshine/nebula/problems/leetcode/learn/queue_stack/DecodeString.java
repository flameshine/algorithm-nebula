package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import com.flameshine.nebula.structures.Stack;

/**
 * №394 Decode String
 *
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
 * Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.
 * For example, there will not be input like 3a or 2[4].
 * The test cases are generated so that the length of the output will never exceed 10^5.
 */
public class DecodeString {

    public static void main(String... args) {
        System.out.println(
            decodeString("3[a2[c]]")
        );
    }

    private static String decodeString(String s) {

        Stack<String> fragments = new Stack<>();
        Stack<Integer> counts = new Stack<>();

        var resultBuilder = new StringBuilder();
        var number = 0;

        for (var i = 0; i < s.length(); i++) {

            var  c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = number * 10 + (c - '0');
            } else if (Character.isLetter(c)) {
                resultBuilder.append(c);
            } else if (c == '[') {
                counts.push(number);
                fragments.push(resultBuilder.toString());
                number = 0;
                resultBuilder = new StringBuilder();
            } else {
                var count = counts.pop();
                var fragment = new StringBuilder(fragments.pop());
                fragment.append(resultBuilder.toString().repeat(Math.max(0, count)));
                resultBuilder = fragment;
            }
        }

        return resultBuilder.toString();
    }
}