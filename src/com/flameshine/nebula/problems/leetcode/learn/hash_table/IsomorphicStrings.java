package com.flameshine.nebula.problems.leetcode.learn.hash_table;

/**
 * №205 Isomorphic Strings
 *
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character, but a character may map to itself.
 */
public class IsomorphicStrings {

    public static void main(String... args) {
        System.out.println(
            isIsomorphic("egg", "add")
        );
    }

    private static boolean isIsomorphic(String s, String t) {

        var map1 = new int[256];
        var map2 = new int[256];

        for (var i = 0; i < s.length(); i++) {

            var sChar = s.charAt(i);
            var tChar = t.charAt(i);

            if (map1[sChar] != map2[tChar]) {
                return false;
            }

            map1[sChar] = i + 1;
            map2[tChar] = i + 1;
        }

        return true;
    }
}