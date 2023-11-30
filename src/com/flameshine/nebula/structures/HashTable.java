package com.flameshine.nebula.structures;

import java.util.Set;
import java.util.HashSet;
import java.util.Collections;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75d;

    private final double loadFactor;

    private Entry<?, ?>[] table;
    private int capacity;
    private int size;

    public HashTable() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashTable(int capacity, double loadFactor) {
        this.table = new Entry<?, ?>[capacity];
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        this.size = 0;
    }

    /**
     * Puts a key/value pair in a table.
     *
     * 1. Check if key and value are present.
     * 2. Calculate the position of an entry based on the key hash.
     * 3. Check if key/value already exist in the table. Return the value if so.
     * 4. Place an entry on the specified position and link to it the previous head.
     * 5. Check if the table expansion needed. Double the size by copying the table if the answer is affirmative.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     *
     * @return The previous value if it exists or null otherwise.
     */
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {

        if (key == null || value == null) {
            throw new NullPointerException();
        }

        var hash = key.hashCode();
        var index = calculateIndex(hash);

        for (var e = (Entry<K, V>) table[index]; e != null; e = e.next) {
            if (e.key.equals(key) && e.hash == hash) {
                var old = e.value;
                e.value = value;
                return old;
            }
        }

        var head = (Entry<K, V>) table[index];

        table[index] = new Entry<>(key, value, hash, head);

        ++size;

        if (((double) size / capacity) >= loadFactor) {
            var newCapacity = capacity * 2;
            var extended = new Entry<?, ?>[newCapacity];
            System.arraycopy(table, 0, extended, 0, table.length);
            table = extended;
            capacity = newCapacity;
        }

        return null;
    }

    /**
     * Removes entry by the specified key.
     *
     * 1. Check if key is present.
     * 2. Calculate the entry position and iterate over linked entries until the entry to remove found.
     * 3. Unlink the entry to remove among with the size value decrease.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     */
    @SuppressWarnings("unchecked")
    public void remove(K key) {

        if (key == null) {
            throw new NullPointerException();
        }

        var hash = key.hashCode();
        var index = calculateIndex(hash);
        var pointer = (Entry<K, V>) table[index];

        Entry<K, V> previous = null;

        while (pointer != null) {
            if (pointer.key.equals(key) && pointer.hash == hash) {
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
            table[index] = pointer.next;
        }

        --size;
    }

    /**
     * Retrieves value by the specified key.
     *
     * 1. Check if the key is present.
     * 2. Calculate the entry position by key hash and retrieve the element if it's present.
     * 3. Iterate over linked entries until the needed entry found.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     *
     * @return Value behind the specified key if present, otherwise null.
     */
    @SuppressWarnings("unchecked")
    public V get(K key) {

        if (key == null) {
            throw new NullPointerException();
        }

        var hash = key.hashCode();
        var index = calculateIndex(hash);

        for (var e = (Entry<K, V>) table[index]; e != null; e = e.next) {
            if (e.key.equals(key) && e.hash == hash) {
                return e.value;
            }
        }

        return null;
    }

    /**
     * Returns a set of entries.
     *
     * 1. Create a result accumulator.
     * 2. Iterate through all entries, selecting non-null ones.
     * 3. Cast the entry to the needed type, as we have to store table keys/values as wildcards.
     * 4. Accumulate the results and make builder unmodifiable before returning.
     *
     * Runtime complexity - O(n).
     *
     * @return Set of entries table holds.
     */
    @SuppressWarnings("unchecked")
    public Set<Entry<K, V>> entrySet() {

        Set<Entry<K, V>> resultBuilder = new HashSet<>();

        for (var e : table) {
            if (e != null) {
                var casted = (Entry<K, V>) e;
                resultBuilder.add(casted);
            }
        }

        return Collections.unmodifiableSet(resultBuilder);
    }

    /**
     * Checks if table contains the key specified.
     *
     * 1. Check if the key passed exists.
     * 2. Calculate the position based on the key's hash.
     * 3. Check if key exists in the table, iterating over linked entries.
     *
     * Runtime complexity - O(m), where m is the number of items in a particular bucket (collision case).
     *
     * @return True if key exists, false otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean containsKey(K key) {

        if (key == null) {
            throw new NullPointerException();
        }

        var hash = key.hashCode();
        var index = calculateIndex(hash);

        for (var e = (Entry<K, V>) table[index]; e != null; e = e.next) {
            if (e.key.equals(key) && e.hash == hash) {
                return true;
            }
        }

        return false;
    }

    /**
     * Checks if the table contains the value specified.
     *
     * 1. Check is the value received is present.
     * 2. Iterate through the table, checking if there is such a value.
     *
     * Runtime complexity - O(n*m), where n is a number of entries in a map and m is the number of items in a particular bucket (collision case).
     *
     * @return True if value exists, false otherwise.
     */
    @SuppressWarnings("unchecked")
    public boolean containsValue(V value) {

        if (value == null) {
            throw new NullPointerException();
        }

        for (var i = 0; i < size; i++) {
            var head = (Entry<K, V>) table[i];
            for (var e = head; e != null; e = e.next) {
                if (head.value.equals(value)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return Arrays.stream(table)
            .filter(Objects::nonNull)
            .map(Entry::toString)
            .collect(
                Collectors.joining(",", "{", "}")
            );
    }

    /**
     * A helper function to calculate an index for the particular hash.
     *
     * @return The index for the hash received.
     */
    private int calculateIndex(int hash) {
        return (hash & 0x7FFFFFFF) % (table.length - 1);
    }

    public static class Entry<K, V> {

        private final K key;
        private final int hash;

        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }
}