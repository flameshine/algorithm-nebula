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

    /**
     * 1. Sort an array
     * 2. Get the first and the last strings from the sorted array
     * 3. Increment a counter as long as their chars are equal
     * 4. Return the longest common prefix based on the counter value
     */
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