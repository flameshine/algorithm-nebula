package com.flameshine.nebula.problems.leetcode.learn.array_and_string;

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

    /**
     * 1. Iterate through both of the strings starting from the end
     * 2. Calculate if we need to carry anything to the next iteration/class
     * 3. Append result to the builder and move on to the next iteration
     */
    private static String addBinary(String a, String b) {

        var builder = new StringBuilder();
        var carry = 0;
        var i = a.length() - 1;
        var j = b.length() - 1;

        while (i >= 0 || j >= 0 || carry == 1) {

            if (i >= 0) {
                carry += a.charAt(i--) - '0';
            }

            if (j >= 0) {
                carry += b.charAt(j--) - '0';
            }

            builder.append(carry % 2);
            carry /= 2;
        }

        return builder.toString();
    }
}