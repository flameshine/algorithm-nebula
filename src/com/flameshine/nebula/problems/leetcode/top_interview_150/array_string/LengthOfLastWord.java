package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №58 Length of Last Word
 *
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * A word is a maximal substring consisting of non-space characters only.
 */
public class LengthOfLastWord {

    public static void main(String... args) {
        System.out.println(
            lengthOfLastWord("Hello World")
        );
    }

    private static int lengthOfLastWord(String s) {

        s = s.trim();

        var length = 0;

        for (var i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            } else {
                ++length;
            }
        }

        return length;
    }
}