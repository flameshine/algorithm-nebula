package com.flameshine.nebula.structures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RandomizedSet {

    private static final int DEFAULT_CAPACITY = 4;

    private int[] items;
    private int capacity;
    private int size;

    public RandomizedSet() {
        this.items = new int[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    /**
     * Inserts an item val into the set if not present.
     *
     * 1. Check if the value already exists.
     * 2. Check the size and increase capacity if needed.
     * 3. Insert a new item to the end of the array.
     *
     * Average runtime complexity - O(1).
     *
     * @return true if the item was not present, false otherwise.
     */
    public boolean insert(int val) {

        for (var i = size - 1; i >= 0; --i) {
            if (items[i] == val) {
                return false;
            }
        }

        if (size == capacity) {
            var newCapacity = capacity * 2;
            var extended = new int[newCapacity];
            System.arraycopy(items, 0, extended, 0, size);
            capacity = newCapacity;
            items = extended;
        }

        items[size++] = val;

        return true;
    }

    /**
     * Removes an item val from the set if present.
     *
     * 1. Check if the value already exists.
     * 2. Swap the value with the last element.
     *
     * Average runtime complexity - O(1).
     *
     * @return true if the item was present, false otherwise.
     */
    public boolean remove(int val) {

        var i = size - 1;

        while (i >= 0) {
            if (items[i] == val) {
                break;
            }
            --i;
        }

        if (i == -1) {
            return false;
        }

        var tmp = items[i];
        items[i] = items[--size];
        items[size] = tmp;

        return true;
    }

    /**
     * Returns a random element from the current set of elements.
     * Each element has the same probability of being returned.
     *
     * 1. Check if the set isn't empty.
     * 2. Calculate the random index to get an item by.
     * 3. Return the result.
     *
     * Runtime complexity - O(1).
     *
     * @return a random element from the current set of elements.
     */
    public int random() {

        if (size == 0) {
            throw new IllegalStateException();
        }

        var randomIndex = (int) (Math.random() * size);

        return items[randomIndex];
    }

    @Override
    public String toString() {
        return Arrays.stream(items)
            .limit(size)
            .mapToObj(Integer::toString)
            .collect(Collectors.joining(
                ", ", "[", "]"
            ));
    }
}