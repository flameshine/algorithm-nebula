package com.flameshine.nebula.structures;

import java.util.Set;

public class HashTable<K, V> {

    private static final int DEFAULT_CAPACITY = 5;
    private static final double DEFAULT_LOAD_FACTOR = 0.75d;

    private Entry<?, ?>[] table;
    private int capacity;
    private double loadFactor;
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
     * 1. Check if value is present.
     * 2. Calculate the position of an entry based on the key hash.
     * 3. Check if key already exists in the table. Return its value if so.
     * 4. Place an entry on the specified position.
     * 5. Check if the table expansion needed. Double the size by copying the table if the answer is affirmative.
     * 6. Return the result.
     */
    @SuppressWarnings("unchecked")
    public V put(K key, V value) {

        if (value == null) {
            throw new NullPointerException();
        }

        var hash = key.hashCode();
        var index = calculateIndex(hash);
        var entry = (Entry<K, V>) table[index];

        if (entry != null) {
            return entry.value;
        }

        var resulting = new Entry<>(hash, key, value);

        table[index] = resulting;

        ++size;

        if (((double) size / capacity) >= loadFactor) {
            var extended = new Entry<?, ?>[capacity * 2];
            System.arraycopy(table, 0, extended, 0, table.length);
            table = extended;
        }

        return resulting.value;
    }

    public void remove(K key) {
        throw new UnsupportedOperationException();
    }

    public Set<Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(K key) {
        throw new UnsupportedOperationException();
    }

    public void containsValue(V value) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }

    private int calculateIndex(int hash) {
        return (hash & 0x7FFFFFFF) % table.length;
    }

    // TODO: consider having a list of values by each key

    private static class Entry<K, V> {

        private int hash;
        private K key;
        private V value;

        public Entry(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }
    }
}