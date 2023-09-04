package com.flameshine.nebula.problems.leetcode.top_interview_150.two_pointers;

/**
 * №125 Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward.
 * Alphanumeric characters include letters and numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 */
public class ValidPalindrome {

    public static void main(String... args) {
        System.out.println(
            isPalindrome("A man, a plan, a canal: Panama")
        );
    }

    private static boolean isPalindrome(String s) {

        var left = 0;
        var right = s.length() - 1;

        while (left < right) {
            var leftChar = s.charAt(left);
            var rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                ++left;
            } else if (!Character.isLetterOrDigit(rightChar)) {
                --right;
            } else {
                if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                    return false;
                }
                ++left;
                --right;
            }
        }

        return true;
    }
}