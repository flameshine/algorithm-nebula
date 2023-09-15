package com.flameshine.nebula.problems.leetcode.top_interview_150.array_string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №380 Insert Delete GetRandom O(1)
 *
 * Implement the RandomizedSet class:
 *   - RandomizedSet() Initializes the RandomizedSet object.
 *   - bool insert(int val) Inserts an item val into the set if not present.
 *     Returns true if the item was not present, false otherwise.
 *   - bool remove(int val) Removes an item val from the set if present.
 *     Returns true if the item was present, false otherwise.
 *   - int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called).
 *     Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 */
public class InsertDeleteGetRandomO1 {

    public static void main(String... args) {

        var randomizedSet = new RandomizedSet();

        randomizedSet.insert(1);
        randomizedSet.insert(2);
        randomizedSet.insert(3);

        System.out.println(
            randomizedSet.remove(1)
        );

        System.out.println(
            randomizedSet.getRandom()
        );
    }

    static class RandomizedSet {

        private final Map<Integer, Integer> map;
        private final List<Integer> list;

        public RandomizedSet() {
            this.map = new HashMap<>();
            this.list = new ArrayList<>();
        }

        public boolean insert(int val) {

            if (map.containsKey(val)) {
                return false;
            }

            map.put(val, list.size());
            list.add(val);

            return true;
        }

        public boolean remove(int val) {

            if (!map.containsKey(val)) {
                return false;
            }

            var index = map.get(val);
            var last = list.get(list.size() - 1);

            list.set(index, last);
            map.put(last, index);
            map.remove(val);
            list.remove(list.size() - 1);

            return true;
        }

        public int getRandom() {
            var random = (int) (Math.random() * list.size());
            return list.get(random);
        }
    }
}