package com.flameshine.nebula.problems.leetcode.learn.beginner;

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

    /**
     * 1. Build a character frequency map of the "magazine"
     * 2. Iterate over the "ransomNote" characters, making the following actions with each iteration:
     *    - check if the value exists in the "magazine" frequency map we build and return false if it isn't the case
     *    - decrement the corresponding value in the map
     * 3. Return true if all characters were present
     */
    private static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> characterFrequency = new HashMap<>();

        for (var character : magazine.toCharArray()) {
            characterFrequency.merge(character, 1, Integer::sum);
        }

        for (var character : ransomNote.toCharArray()) {
            var magazineValue = characterFrequency.getOrDefault(character, 0);
            if (magazineValue == 0) {
                return false;
            }
            characterFrequency.merge(character, -1, Integer::sum);
        }

        return true;
    }
}