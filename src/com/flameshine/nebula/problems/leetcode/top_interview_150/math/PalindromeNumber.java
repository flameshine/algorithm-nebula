package com.flameshine.nebula.problems.leetcode.top_interview_150.math;

/**
 * №9 Palindrome Number
 *
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 */
public class PalindromeNumber {

    public static void main(String... args) {
        System.out.println(
            isPalindrome(121)
        );
    }

    private static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        var reversed = 0;
        var temporary = x;

        while (temporary != 0) {
            reversed = reversed * 10 + temporary % 10;
            temporary /= 10;
        }

        return x == reversed;
    }
}