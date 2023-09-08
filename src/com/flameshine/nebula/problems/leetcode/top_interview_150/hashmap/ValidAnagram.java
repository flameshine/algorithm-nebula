package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * №242 Valid Anagram
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class ValidAnagram {

    public static void main(String... args) {
        System.out.println(
            isAnagram("anagram", "nagaram")
        );
    }

    private static boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> characterToFrequency = new HashMap<>();

        for (var i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            characterToFrequency.put(sChar, characterToFrequency.getOrDefault(sChar, 0) + 1);
            characterToFrequency.put(tChar, characterToFrequency.getOrDefault(tChar, 0) - 1);
        }

        for (var c : s.toCharArray()) {
            if (characterToFrequency.get(c) != 0) {
                return false;
            }
        }

        return true;
    }
}