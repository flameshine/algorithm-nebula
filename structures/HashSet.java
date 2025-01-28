package com.flameshine.nebula.structures;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashSet<T> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75d;

    private final double loadFactor;

    private Item<?>[] items;
    private int capacity;
    private int size;

    public HashSet() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashSet(int capacity, double loadFactor) {
        this.items = new Item<?>[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    /**
     * Adds an item to a set.
     *
     * 1. Check if the new value to add is present.
     * 2. Calculate the position of an item based on the key hash.
     * 3. Check if key/value already exist in the table.
     * 4. Place an entry on the specified position and link to it the previous head.
     * 5. Check if the table expansion needed. Double the size by copying the table if the answer is affirmative.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     */
    @SuppressWarnings("unchecked")
    public void add(T value) {

        if (value == null) {
            throw new NullPointerException();
        }

        var hash = value.hashCode();
        var index = calculateIndex(hash);

        for (var i = (Item<T>) items[index]; i != null; i = i.next) {
            if (i.value.equals(value) && i.hash == hash) {
                i.value = value;
                return;
            }
        }

        var head = (Item<T>) items[index];

        items[index] = new Item<>(hash, value, head);

        ++size;

        if (((double) size / capacity) >= loadFactor) {
            var newCapacity = capacity * 2;
            var extended = new Item<?>[newCapacity];
            System.arraycopy(items, 0, extended, 0, items.length);
            items = extended;
            capacity = newCapacity;
        }
    }

    /**
     * Removes value from a set.
     *
     * 1. Check if value is present.
     * 2. Calculate the item position and iterate over linked items until the one to remove found.
     * 3. Unlink the item to remove among with the size value decrease.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     */
    @SuppressWarnings("unchecked")
    public void remove(T value) {

        if (value == null) {
            throw new NullPointerException();
        }

        var hash = value.hashCode();
        var index = calculateIndex(hash);
        var pointer = (Item<T>) items[index];

        Item<T> previous = null;

        while (pointer != null) {
            if (pointer.value.equals(value) && pointer.hash == hash) {
                break;
            }
            previous = pointer;
            pointer = pointer.next;
        }

        if (pointer == null) {
            return;
        }

        if (previous != null) {
            previous.next = pointer.next;
        } else {
            items[index] = pointer.next;
        }

        --size;
    }

    /**
     * Checks if set contains the value specified.
     *
     * 1. Check if the value passed exists.
     * 2. Calculate the position based on the value's hash.
     * 3. Check if value exists in the set, iterating over linked items.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     *
     * @return True if value exists in set, false otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean contains(T value) {

        if (value == null) {
            throw new NullPointerException();
        }

        var hash = value.hashCode();
        var index = calculateIndex(hash);

        for (var pointer = (Item<T>) items[index]; pointer != null; pointer = pointer.next) {
            if (pointer.value.equals(value) && pointer.hash == hash) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return Arrays.stream(items)
            .filter(Objects::nonNull)
            .map(Item::toString)
            .collect(Collectors.joining(
                ",", "{", "}"
            ));
    }

    /**
     * A helper function to calculate an index for the particular hash.
     *
     * @return The index for the hash received.
     */
    private int calculateIndex(int hash) {
        return (hash & 0x7FFFFFFF) % (items.length - 1);
    }

    public static class Item<T> {

        private final int hash;

        private T value;
        private Item<T> next;

        public Item(int hash, T value, Item<T> next) {
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}