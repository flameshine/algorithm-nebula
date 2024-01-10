package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.HashSet;
import java.util.Set;

/**
 * №771 Jewels and Stones
 *
 * You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have.
 * Each character in stones is a type of stone you have.
 * You want to know how many of the stones you have are also jewels.
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 */
public class JewelsAndStones {

    public static void main(String... args) {
        System.out.println(
            numJewelsInStones("aA", "aAAbbbb")
        );
    }

    private static int numJewelsInStones(String jewels, String stones) {

        Set<Character> uniqueJewels = new HashSet<>();

        for (var c : jewels.toCharArray()) {
            uniqueJewels.add(c);
        }

        var result = 0;

        for (var stone : stones.toCharArray()) {
            if (uniqueJewels.contains(stone)) {
                ++result;
            }
        }

        return result;
    }
}