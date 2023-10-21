package com.flameshine.nebula.structures;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.stream.Collectors;

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
     *
     * Runtime complexity - O(1).
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
     * Runtime complexity - O(1).
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
     * 1. Verify that the stack isn't empty.
     * 2. Return the top element of the stack array.
     *
     * Runtime complexity - O(1).
     *
     * @return Element from the top of the stack.
     */
    @SuppressWarnings("unchecked")
    public T peek() {

        if (size == 0) {
            throw new EmptyStackException();
        }

        return (T) elements[size - 1];
    }

    /**
     * Returns position of the element from top of the stack.
     *
     * 1. Iterate over elements starting from the top of the stack incrementing a counter.
     * 2. Return the counter value if element present, otherwise return -1.
     *
     * Runtime complexity - O(n).
     *
     * @return Position of the element from the top of the stack and -1 if element doesn't exist.
     */
    public int search(T data) {

        var counter = 1;

        for (var i = size - 1; i >= 0; i--) {
            if (elements[i].equals(data)) {
                return counter;
            }
            ++counter;
        }

        return -1;
    }

    @Override
    public String toString() {
        return Arrays.stream(elements)
            .limit(size)
            .map(Object::toString)
            .collect(
                Collectors.joining(", ", "[", "]")
            );
    }
}