package com.flameshine.nebula.problems.leetcode.top_interview_150.sliding_window;

import java.util.Map;
import java.util.HashMap;

/**
 * №76 Minimum Window Substring
 *
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window.
 * If there is no such substring, return the empty string "".
 * The testcases will be generated such that the answer is unique.
 */
public class MinimumWindowSubstring {

    public static void main(String... args) {
        System.out.println(
            minWindow("ADOBECODEBANC", "ABC")
        );
    }

    private static String minWindow(String s, String t) {

        Map<Character, Integer> targetCharacterToFrequency = new HashMap<>();

        for (var c : t.toCharArray()) {
            targetCharacterToFrequency.merge(c, 1, Integer::sum);
        }

        var count = targetCharacterToFrequency.size();
        var minimum = s.length();
        var i = 0;
        var j = 0;
        var left = 0;
        var right = s.length() - 1;
        var isFound = false;

        while (j < s.length()) {

            var endChar = s.charAt(j++);
            if (targetCharacterToFrequency.containsKey(endChar)) {
                targetCharacterToFrequency.put(endChar, targetCharacterToFrequency.get(endChar) - 1);
                if (targetCharacterToFrequency.get(endChar) == 0) {
                    --count;
                }
            }

            if (count > 0) {
                continue;
            }

            while (count == 0) {
                var startChar = s.charAt(i++);
                if (targetCharacterToFrequency.containsKey(startChar)) {
                    targetCharacterToFrequency.put(startChar, targetCharacterToFrequency.get(startChar) + 1);
                    if (targetCharacterToFrequency.get(startChar) > 0) {
                        ++count;
                    }
                }
            }

            var distance = j - i;

            if (distance < minimum) {
                left = i;
                right = j;
                minimum = distance;
                isFound = true;
            }
        }

        return isFound ? s.substring(left - 1, right) : "";
    }
}