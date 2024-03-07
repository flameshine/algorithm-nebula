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

        String[] strings = { "flower", "flow", "flight" };

        System.out.println(
            longestCommonPrefix(strings)
        );
    }

    private static String longestCommonPrefix(String[] strings) {

        Arrays.sort(strings);

        var s1 = strings[0];
        var s2 = strings[strings.length - 1];
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