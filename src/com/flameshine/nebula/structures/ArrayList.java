package com.flameshine.nebula.structures;

public class ArrayList<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int capacity;
    private int size;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.capacity = DEFAULT_CAPACITY;
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
     * 2. Assign the value to a cell
     * 3. Increment the size
     */
    public void add(T element) {

        if (size == capacity) {
            var newCapacity = capacity * 2;
            var extended = new Object[newCapacity];
            System.arraycopy(elements, 0, extended, 0, size);
            capacity = newCapacity;
            elements = extended;
        }

        elements[size] = element;

        ++size;
    }

    /**
     * Removes the first appearance of the received element.
     *
     * 1. Find the position of element in the list (for simplicity, the brute-force approach will be used)
     * 2. Shift the array on one position
     * 3. Set the value of removed element to null to let it be properly cleaned up
     * 4. Decrement the size value
     */
    public void remove(T element) {

        var index = -1;

        for (var i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
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
     */
    public Object get(int index) {
        return elements[index];
    }

    /**
     * Returns a position of the first occurrence of the element.
     *
     * 1. Find the first equal element iterating over an array and return its index.
     * 2. Return -1 if no such element found.
     */
    public int indexOf(T element) {

        for (var i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public String toString() {

        var builder = new StringBuilder("[");

        for (var i = 0; i < size; i++) {
            builder.append(elements[i]);
            if (i != size - 1) {
                builder.append(", ");
            }
        }

        return builder.append("]").toString();
    }
}