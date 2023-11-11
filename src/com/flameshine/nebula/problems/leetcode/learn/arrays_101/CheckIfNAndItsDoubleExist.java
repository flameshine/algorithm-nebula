package com.flameshine.nebula.problems.leetcode.learn.arrays_101;

import java.util.Map;
import java.util.HashMap;

/**
 * №1346 Check If N and Its Double Exist
 *
 * Given an array arr of integers, check if there exist two indices i and j such that:
 *   - i != j
 *   - 0 <= i, j < arr.length
 *   - arr[i] == 2 * arr[j]
 */
public class CheckIfNAndItsDoubleExist {

    public static void main(String... args) {

        int[] arr = { 10, 2, 5, 3 };

        System.out.println(
            checkIfExist(arr)
        );
    }

    private static boolean checkIfExist(int[] arr) {

        Map<Integer, Integer> numbersToIndices = new HashMap<>();

        for (var i = 0; i < arr.length; i++) {
            numbersToIndices.put(arr[i], i);
        }

        for (var i = 0; i < arr.length; i++) {
            var doubled = arr[i] * 2;
            if (numbersToIndices.containsKey(doubled) && numbersToIndices.get(doubled) != i) {
                return true;
            }
        }

        return false;
    }
}