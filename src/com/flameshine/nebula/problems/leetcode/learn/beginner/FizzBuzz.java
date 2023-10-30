package com.flameshine.nebula.problems.leetcode.learn.beginner;

import java.util.List;
import java.util.ArrayList;

/**
 * №412 Fizz Buzz
 *
 * Given an integer n, return a string array answer (1-indexed) where:
 *   - answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 *   - answer[i] == "Fizz" if i is divisible by 3.
 *   - answer[i] == "Buzz" if i is divisible by 5.
 *   - answer[i] == i (as a string) if none of the above conditions are true.
 */
public class FizzBuzz {

    public static void main(String... args) {
        System.out.println(
            fizzBuzz(5)
        );
    }

    private static List<String> fizzBuzz(int n) {

        List<String> result = new ArrayList<>(n);

        for (var i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }

        return result;
    }
}