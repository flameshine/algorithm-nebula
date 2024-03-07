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

        int[] array = { 10, 2, 5, 3 };

        System.out.println(
            checkIfExist(array)
        );
    }

    private static boolean checkIfExist(int[] array) {

        Map<Integer, Integer> numbersToIndices = new HashMap<>();

        for (var i = 0; i < array.length; i++) {
            numbersToIndices.put(array[i], i);
        }

        for (var i = 0; i < array.length; i++) {
            var doubled = array[i] * 2;
            if (numbersToIndices.containsKey(doubled) && numbersToIndices.get(doubled) != i) {
                return true;
            }
        }

        return false;
    }
}