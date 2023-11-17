package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.Arrays;

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

        Arrays.sort(strs);

        var s1 = strs[0];
        var s2 = strs[strs.length - 1];
        var i = 0;

        while (i < s1.length() && i < s2.length()) {
            if (s1.charAt(i) == s2.charAt(i)) {
                i++;
            } else {
                break;
            }
        }

        return s1.substring(0, i);
    }
}