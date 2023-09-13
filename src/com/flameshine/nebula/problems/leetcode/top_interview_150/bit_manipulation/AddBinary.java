package com.flameshine.nebula.problems.leetcode.top_interview_150.bit_manipulation;

/**
 * №67 Add Binary
 *
 * Given two binary strings a and b, return their sum as a binary string.
 */
public class AddBinary {

    public static void main(String... args) {
        System.out.println(
            addBinary("11", "1")
        );
    }

    private static String addBinary(String a, String b) {

        var result = new StringBuilder();
        var i = a.length() - 1;
        var j = b.length() - 1;
        var carry = 0;

        while (i >= 0 || j >= 0) {

            var sum = carry;

            if (i >= 0) {
                sum += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += b.charAt(j--) - '0';
            }

            carry = sum > 1 ? 1 : 0;

            result.append(sum % 2);
        }

        if (carry != 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }
}