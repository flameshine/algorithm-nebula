package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

import java.util.List;
import java.util.ArrayList;

/**
 * №151 Reverse Words in a String
 *
 * Given an input string s, reverse the order of the words.
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * Return a string of the words in reverse order concatenated by a single space.
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 */
public class ReverseWordsInAString {

    public static void main(String... args) {
        System.out.println(
            reverseWords("the sky is blue")
        );
    }

    private static String reverseWords(String s) {

        List<String> words = new ArrayList<>();

        var wordBuilder = new StringBuilder();
        var i = 0;

        while (i < s.length()) {
            var c = s.charAt(i++);
            if (c == ' ' && !wordBuilder.isEmpty()) {
                words.add(wordBuilder.toString());
                wordBuilder.setLength(0);
            } else if (c != ' ') {
                wordBuilder.append(c);
            }
        }

        if (!wordBuilder.isEmpty()) {
            words.add(
                wordBuilder.toString()
            );
        }

        var left = 0;
        var right = words.size() - 1;

        while (left < right) {
            var tmp = words.get(left);
            words.set(left++, words.get(right));
            words.set(right--, tmp);
        }

        return String.join(" ", words);
    }
}