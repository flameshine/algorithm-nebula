package com.flameshine.nebula.structures;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int capacity;
    private int size;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        this.elements = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Adds element to the end of the array list.
     *
     * 1. Check if the size went above the capacity. If so:
     *    - Double the capacity value
     *    - Create an extended array with the new size
     *    - Copy values from the old array to the new one
     *    - Re-assign the variables
     * 2. Assign the value to a cell.
     * 3. Increment the size.
     *
     * Runtime complexity - O(1).
     */
    public void add(T data) {

        if (size == capacity) {
            var newCapacity = capacity * 2;
            var extended = new Object[newCapacity];
            System.arraycopy(elements, 0, extended, 0, size);
            capacity = newCapacity;
            elements = extended;
        }

        elements[size] = data;

        ++size;
    }

    /**
     * Removes the first appearance of the received element.
     *
     * 1. Find the position of element in the list (for simplicity, the brute-force approach will be used).
     * 2. Shift the array on one position.
     * 3. Set the value of removed element to null to let it be properly cleaned up.
     * 4. Decrement the size value.
     *
     * Runtime complexity - O(n).
     */
    public void remove(T data) {

        var index = -1;

        for (var i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return;
        }

        var numberOfElementsToShift = size - index - 1;

        System.arraycopy(elements, index + 1, elements, index, numberOfElementsToShift);

        elements[--size] = null;
    }

    /**
     * Retrieves element by index.
     *
     * Runtime complexity - O(1).
     *
     * @return An element that stands behind the specified index.
     */
    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) elements[index];
    }

    /**
     * Returns a position of the first occurrence of the element.
     *
     * 1. Find the first equal element iterating over an array and return its index.
     * 2. Return -1 if no such element found.
     *
     * Runtime complexity - O(n).
     */
    public int indexOf(T data) {

        for (var i = 0; i < size; i++) {
            if (elements[i].equals(data)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements)
            .limit(size)
            .map(Object::toString)
            .collect(Collectors.joining(
                ", ", "[", "]"
            ));
    }
}