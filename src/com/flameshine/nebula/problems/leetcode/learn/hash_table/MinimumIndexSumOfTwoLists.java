package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №599 Minimum Index Sum of Two Lists
 *
 * Given two arrays of strings list1 and list2, find the common strings with the least index sum.
 * A common string is a string that appeared in both list1 and list2.
 * A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.
 * Return all the common strings with the least index sum.
 * Return the answer in any order.
 */
public class MinimumIndexSumOfTwoLists {

    public static void main(String... args) {

        var list1 = new String[] { "Shogun", "Tapioca Express", "Burger King", "KFC" };
        var list2 = new String[] { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };

        System.out.println(
            Arrays.toString(
                findRestaurant(list1, list2)
            )
        );
    }

    private static String[] findRestaurant(String[] list1, String[] list2) {

        Map<String, Integer> nameToIndex = new HashMap<>();

        for (var i = 0; i < list1.length; i++) {
            nameToIndex.put(list1[i], i);
        }

        List<String> resultBuilder = new ArrayList<>();

        var minIndexSum = Integer.MAX_VALUE;

        for (var i = 0; i < list2.length; i++) {
            if (nameToIndex.containsKey(list2[i])) {
                var index = nameToIndex.get(list2[i]);
                var indexSum = index + i;
                if (indexSum < minIndexSum) {
                    resultBuilder.clear();
                    resultBuilder.add(list2[i]);
                    minIndexSum = indexSum;
                } else if (indexSum == minIndexSum) {
                    resultBuilder.add(list2[i]);
                }
            }
        }

        return resultBuilder.toArray(String[]::new);
    }
}