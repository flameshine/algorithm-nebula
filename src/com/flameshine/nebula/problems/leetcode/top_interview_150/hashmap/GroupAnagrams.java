package com.flameshine.nebula.problems.leetcode.top_interview_150.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * №49 Isomorphic Strings
 *
 * Given an array of strings strs, group the anagrams together.
 * You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
public class GroupAnagrams {

    public static void main(String... args) {

        String[] strs = { "a", "a" };

        System.out.println(
            groupAnagrams(strs)
        );
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> mapping = new HashMap<>();

        for (var s : strs) {
            var chars = s.toCharArray();
            Arrays.sort(chars);
            var sorted = new String(chars);
            mapping.putIfAbsent(sorted, new ArrayList<>());
            mapping.get(sorted).add(s);
        }

        return new ArrayList<>(mapping.values());
    }
}