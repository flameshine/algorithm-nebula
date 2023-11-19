package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

/**
 * №557 Reverse Words in a String III
 *
 * Given a string s, reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 */
public class ReverseWordsInAString3 {

    public static void main(String... args) {
        System.out.println(
            reverseWords("Let's take LeetCode contest")
        );
    }

    private static String reverseWords(String s) {

        var resultBuilder = new StringBuilder();
        var words = s.split(" ");

        for (var i = 0; i < words.length; i++) {

            resultBuilder.append(
                reverseString(words[i])
            );

            if (i != words.length - 1) {
                resultBuilder.append(" ");
            }
        }

        return resultBuilder.toString();
    }

    private static String reverseString(String s) {

        var chars = s.toCharArray();
        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            var tmp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = tmp;
        }

        return new String(chars);
    }
}