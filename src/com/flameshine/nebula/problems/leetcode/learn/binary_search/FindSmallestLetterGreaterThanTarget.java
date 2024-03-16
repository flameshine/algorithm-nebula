package com.flameshine.nebula.problems.leetcode.learn.binary_search;

/**
 * №744 Find Smallest Letter Greater Than Target
 *
 * You are given an array of characters letters that is sorted in non-decreasing order, and a character target.
 * There are at least two different characters in letters.
 * Return the smallest character in letters that is lexicographically greater than target.
 * If such a character does not exist, return the first character in letters.
 */
public class FindSmallestLetterGreaterThanTarget {

    public static void main(String... args) {

        char[] letters = { 'c', 'f', 'j' };

        System.out.println(
            nextGreatestLetter(letters, 'a')
        );
    }

    private static char nextGreatestLetter(char[] letters, char target) {

        if (target >= letters[letters.length - 1]) {
            return letters[0];
        }

        var left = 0;
        var right = letters.length - 1;

        while (left <= right) {
            var middle = left + (right - left) / 2;
            if (letters[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return letters[left];
    }
}