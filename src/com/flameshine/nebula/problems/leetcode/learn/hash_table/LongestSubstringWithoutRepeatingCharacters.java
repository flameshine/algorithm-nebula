package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * №3 Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String... args) {
        System.out.println(
            lengthOfLongestSubstring("abcabcbb")
        );
    }

    private static int lengthOfLongestSubstring(String s) {

        var result = 0;
        var i = 0;
        var j = 0;

        Set<Character> seen = new HashSet<>();

        while (j < s.length()) {
            if (!seen.contains(s.charAt(j))) {
                seen.add(s.charAt(j++));
                result = Math.max(result, seen.size());
            } else {
                seen.remove(s.charAt(i++));
            }
        }

        return result;
    }
}