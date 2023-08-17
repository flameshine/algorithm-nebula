package com.flameshine.nebula.structures;

import java.util.EmptyStackException;

public class Stack<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elements;
    private int capacity;
    private int size;

    public Stack() {
        this(DEFAULT_CAPACITY);
    }

    public Stack(int capacity) {
        this.elements = new Object[capacity];
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Pushes data to a stack.
     *
     * 1. Check if we run above the allowed capacity. If so, do the following:
     *    - Create the extended array with doubled size
     *    - Copy the existing elements to the newly created array
     *    - Assign new property values
     * 2. Add the new element to the extended array.
     * 3. Increment the size value.
     */
    public void push(T data) {

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
     * Removes an element from the top of the stack.
     *
     * 1. Verify that the stack isn't empty.
     * 2. Remove an element from the top of the stack.
     * 3. Return value of the removed element.
     *
     * @return Element from the top of the stack.
     */
    @SuppressWarnings("unchecked")
    public T pop() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        var target = elements[size -1];

        elements[--size] = null;

        return (T) target;
    }

    /**
     * Returns (but not removes) an element from the top of the stack.
     *
     * 1.
     *
     * @return Element from the top of the stack.
     */
    public T peek() {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns position of the element from top of the stack.
     *
     * 1.
     *
     * @return Position of the element from the top of the stack.
     */
    public int search(T data) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}