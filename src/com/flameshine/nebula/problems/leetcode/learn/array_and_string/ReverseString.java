package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

/**
 * №344 Reverse String
 *
 * Write a function that reverses a string.
 * The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
public class ReverseString {

    public static void main(String... args) {

        char[] s = { 'h', 'e', 'l', 'l', 'o' };

        reverseString(s);

        System.out.println(s);
    }

    private static void reverseString(char[] s) {

        var left = 0;
        var right = s.length - 1;

        while (left < right) {
            var tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            ++left;
            --right;
        }
    }
}