package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashMap;
import java.util.Map;

/**
 * №387 First Unique Character in a String
 *
 * Given a string s, find the first non-repeating character in it and return its index.
 * If it does not exist, return -1.
 */
public class FirstUniqueCharacterInAString {

    public static void main(String... args) {
        System.out.println(
            firstUniqChar("leetcode")
        );
    }

    private static int firstUniqChar(String s) {

        Map<Character, Integer> characterToCount = new HashMap<>();

        for (var c : s.toCharArray()) {
            characterToCount.merge(c, 1, Integer::sum);
        }

        for (var i = 0; i < s.length(); i++) {
            if (characterToCount.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}