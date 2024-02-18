package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

/**
 * №151 Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
public class ReverseWordsInAString {

    public static void main(String... args) {
        System.out.println(
            reverseWords("the sky is blue")
        );
    }

    /**
     * 1. Split the string by the whitespaces between words
     * 2. Iterate over the words starting from the right and append them to the result separating by a single whitespace
     */
    private static String reverseWords(String s) {

        var words = s.trim().split("\\s+");
        var result = new StringBuilder(words.length);

        for (var i = words.length - 1; i >= 0; --i) {
            result.append(words[i]);
            if (i != 0) {
                result.append(' ');
            }
        }

        return result.toString();
    }
}