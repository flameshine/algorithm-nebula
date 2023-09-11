package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

/**
 * №28 Find the Index of the First Occurrence in a String
 *
 * Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {

    public static void main(String... args) {
        System.out.println(
            strStr("sadbutsad", "sad")
        );
    }

    private static int strStr(String haystack, String needle) {

        for (var i = 0; i <= haystack.length() - needle.length(); i++) {
            if (haystack.startsWith(needle, i)) {
                return i;
            }
        }

        return -1;
    }
}