package com.flameshine.nebula.problems.leetcode.top_interview_150.bit_manipulation;

/**
 * №191 Number of 1 Bits
 *
 * Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 *
 * Note:
 *
 *   - Note that in some languages, such as Java, there is no unsigned integer type.
 *     In this case, both input and output will be given as a signed integer type.
 *     They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 *   - In Java, the compiler represents the signed integers using 2's complement notation.
 *     Therefore, in Example 3, the input represents the signed integer -3 and the output represents the signed integer -3.
 */
public class NumberOf1Bits {

    public static void main(String... args) {

        var n = Integer.parseInt("00000000000000000000000000001011", 2);

        System.out.println(
            hammingWeight(n)
        );
    }

    private static int hammingWeight(int n) {

        var counter = 0;

        for (var i = 0; i < 32; i++) {
            counter += n & 1;
            n >>= 1;
        }

        return counter;
    }
}