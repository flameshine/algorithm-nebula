package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * №290 Word Pattern
 *
 * Given a pattern and a string s, find if s follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
public class WordPattern {

    public static void main(String... args) {
        System.out.println(
            wordPattern("abba", "dog cat cat dog")
        );
    }

    private static boolean wordPattern(String pattern, String s) {

        var words = s.split(" ");

        if (words.length != pattern.length()) {
            return false;
        }

        Map<Character, String> characterToWord = new HashMap<>();
        Map<String, Character> wordToCharacter = new HashMap<>();

        for (var i = 0; i < pattern.length(); i++) {

            var character = pattern.charAt(i);
            var word = words[i];

            characterToWord.putIfAbsent(character, word);
            wordToCharacter.putIfAbsent(word, character);

            if (!characterToWord.get(character).equals(word) || !wordToCharacter.get(word).equals(character)) {
                return false;
            }
        }

        return true;
    }
}