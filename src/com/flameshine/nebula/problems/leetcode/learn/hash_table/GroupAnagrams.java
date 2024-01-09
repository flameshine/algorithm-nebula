package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №49 Group Anagrams
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public static void main(String... args) {

        var strs = new String[] { "duh", "ill" };

        System.out.println(
            groupAnagrams(strs)
        );
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<Integer, List<String>> stringsGroupedByHashes = new HashMap<>();

        for (var s : strs) {
            var hash = buildHash(s);
            var strings = stringsGroupedByHashes.getOrDefault(hash, new ArrayList<>());
            strings.add(s);
            stringsGroupedByHashes.put(hash, strings);
        }

        return stringsGroupedByHashes.values().stream()
            .toList();
    }

    private static int buildHash(String s) {
        var chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }
}