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

    /**
     * 1. Iterate over the array using two pointer approach so:
     *    - one pointer points at the left part of a string
     *    - another pointer at the right one
     *    - the loop is exited when the left one is equal to the right one
     * 2. Swap the chars pointers are pointing to together
     */
    private static void reverseString(char[] s) {

        var left = 0;
        var right = s.length - 1;

        while (left < right) {
            var tmp = s[left];
            s[left++] = s[right];
            s[right--] = tmp;
        }
    }
}