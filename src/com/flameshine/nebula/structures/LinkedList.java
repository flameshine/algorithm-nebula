package com.flameshine.nebula.structures;

import java.util.NoSuchElementException;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Adds element to the end of the list.
     *
     * 1. Create a node to store the data.
     * 2. Check if the list is empty.
     * 3. If the list is empty, set the element as head.
     * 4. Otherwise, retrieve the last element and link the element to add.
     * 5. Set the new node as a new tail.
     *
     * Runtime complexity - O(1).
     */
    public void add(T element) {

        var node = new Node<>(element);

        if (head == null) {
            head = node;
        } else {
            var previousTail = tail;
            previousTail.next = node;
            node.previous = previousTail;
        }

        tail = node;

        ++size;
    }

    /**
     * Removes the first occurrence of the element.
     *
     * 1. Find the element through the iteration.
     * 2. Unlink the element in its neighbours.
     *
     * Runtime complexity - O(n).
     */
    public void remove(T element) {

        var pointer = head;

        Node<T> target = null;

        while (pointer != null) {
            if (pointer.data.equals(element)) {
                target = pointer;
            }
            pointer = pointer.next;
        }

        if (target == null) {
            throw new NoSuchElementException("Not found");
        }

        target.previous.next = target.next;
        target.next.previous = target.previous;

        --size;
    }

    /**
     * Retrieves the element by index.
     *
     * 1. Check if index is valid.
     * 2. Iterate over the indexes until list size, keeping track of the elements.
     * 3. If the index has reached its value, grab the corresponding element.
     *
     * Note, that the embedded implementation iterates over the half of the list only,
     * starting either from head or tail, but we'll always go from the head for simplicity.
     *
     * Runtime complexity - O(n).
     *
     * @return The element that stands behind the specified index.
     */
    public T get(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        var current = head;

        for (var i = 0; i < size; i++) {
            if (i == index) {
                return current.data;
            }
            current = current.next;
        }

        throw new IllegalStateException();
    }

    /**
     * Return an index of the first occurrence of the element specified.
     *
     * 1. Iterate over the indexes until list size, keeping track of the elements.
     * 2. If the element found, return the index of iteration.
     * 3. If no element found, return -1.
     *
     * Runtime complexity - O(n).
     *
     * @return Index of the element specified.
     */
    public int indexOf(T element) {

        var pointer = head;

        for (var i = 0; i < size; i++) {
            if (pointer.data.equals(element)) {
                return i;
            }
            pointer = pointer.next;
        }

        return -1;
    }

    @Override
    public String toString() {

        var builder = new StringBuilder("[");
        var pointer = head;

        while (pointer != null) {
            builder.append(pointer.data);
            var next = pointer.next;
            if (next != null) {
                builder.append(", ");
            }
            pointer = next;
        }

        return builder.append("]").toString();
    }

    private static class Node<T> {

        private final T data;

        private Node<T> previous;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}