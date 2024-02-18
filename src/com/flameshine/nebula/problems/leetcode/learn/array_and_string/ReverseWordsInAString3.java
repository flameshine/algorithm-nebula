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

    /**
     * 1. Split the string by whitespaces
     * 2. Reverse a word and append it to the result adding a whitespace for each word
     */
    private static String reverseWords(String s) {

        var resultBuilder = new StringBuilder();
        var words = s.split("\\s+");

        for (var i = 0; i < words.length; i++) {
            var reversed = reverse(words[i]);
            resultBuilder.append(reversed);
            if (i != words.length - 1) {
                resultBuilder.append(' ');
            }
        }

        return resultBuilder.toString();
    }

    private static String reverse(String s) {

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