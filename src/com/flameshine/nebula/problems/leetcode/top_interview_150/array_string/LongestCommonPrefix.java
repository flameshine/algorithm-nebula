package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №14 Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 */
public class LongestCommonPrefix {

    public static void main(String... args) {

        String[] strs = { "flower", "flow", "flight" };

        System.out.println(
            longestCommonPrefix(strs)
        );
    }

    private static String longestCommonPrefix(String[] strs) {

        var prefix = strs[0];

        for (var i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}