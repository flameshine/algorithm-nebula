package com.flameshine.nebula.problems.leetcode.top_interview_150.two_pointers;

/**
 * №392 Is Subsequence
 *
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 */
public class IsSubsequence {

    public static void main(String... args) {
        System.out.println(
            isSubsequence("axc", "ahbgdc")
        );
    }

    private static boolean isSubsequence(String s, String t) {

        var left = 0;
        var right = 0;

        while (left < s.length() && right < t.length()) {
            if (s.charAt(left) == t.charAt(right)) {
                ++left;
            }
            ++right;
        }

        return left == s.length();
    }
}