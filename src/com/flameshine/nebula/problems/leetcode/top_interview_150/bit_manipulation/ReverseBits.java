package com.flameshine.nebula.problems.leetcode.top_interview_150.bit_manipulation;

/**
 * №190 Reverse Bits
 *
 * Reverse bits of a given 32 bits unsigned integer.
 *
 * Note:
 *
 *   - Note that in some languages, such as Java, there is no unsigned integer type.
 *     In this case, both input and output will be given as a signed integer type.
 *     They should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 *   - In Java, the compiler represents the signed integers using 2's complement notation.
 *     Therefore, in Example 2 above, the input represents the signed integer -3 and the output represents the signed integer -1073741825.
 */
public class ReverseBits {

    public static void main(String... args) {

        var n = Integer.parseInt("00000010100101000001111010011100", 2);

        System.out.println(
            reverseBits(n)
        );
    }

    private static int reverseBits(int n) {

        var reversed = 0;

        for (var i = 0; i < 32; i++) {
            reversed <<= 1;
            reversed |= n & 1;
            n >>= 1;
        }

        return reversed;
    }
}