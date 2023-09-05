package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * №383 Ransom Note
 *
 * Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
 * Each letter in magazine can only be used once in ransomNote.
 */
public class RansomNote {

    public static void main(String... args) {
        System.out.println(
            canConstruct("aa", "aab")
        );
    }

    private static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineCharactersToFrequency = new HashMap<>();

        for (var c : magazine.toCharArray()) {
            magazineCharactersToFrequency.merge(c, 1, Integer::sum);
        }

        for (var c : ransomNote.toCharArray()) {
            if (!magazineCharactersToFrequency.containsKey(c)) {
                return false;
            }
            var magazineValue = magazineCharactersToFrequency.get(c);
            if (magazineValue == 0) {
                return false;
            }
            magazineCharactersToFrequency.put(c, magazineValue - 1);
        }

        return true;
    }
}