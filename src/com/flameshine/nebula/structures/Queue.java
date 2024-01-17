package com.flameshine.nebula.structures;

public class Queue<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private final int capacity;

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Enqueues an element.
     *
     * 1. First, let's make sure we'll not run out of the specified capacity.
     * 2. Then, we need to check if the head of the queue is null or not:
     *    - If it is, set an element as a head.
     *    - Otherwise, re-link the elements, placing the element to add as a new tail.
     *
     * Runtime complexity - O(1).
     */
    public void enqueue(T data) {

        if (size == capacity) {
            throw new IllegalStateException();
        }

        var node = new Node<>(data);

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
     * Dequeues an element.
     *
     * 1. Verify that the head isn't null.
     * 2. Save the result value and unlink the tail node.
     * 3. Decrement the size and return the saved result.
     *
     * Runtime complexity - O(1).
     *
     * @return An element from the tail of the queue.
     */
    public T dequeue() {

        if (head == null) {
            throw new IllegalStateException();
        }

        var result = tail;

        tail = tail.previous;
        tail.next = null;

        --size;

        return result.data;
    }

    /**
     * Returns the last element from the queue.
     *
     * 1. Verify that the head isn't null.
     * 2. Return the tail value.
     *
     * Runtime complexity - O(1).
     *
     * @return The element from the tail of the queue.
     */
    public T peek() {

        if (head == null) {
            throw new IllegalStateException();
        }

        return tail.data;
    }

    /**
     * Returns the size of the queue.
     *
     * Runtime complexity - O(1).
     *
     * @return Number of elements in the queue.
     */
    public int size() {
        return size;
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

        private Node<T> next;
        private Node<T> previous;

        public Node(T data) {
            this.data = data;
        }
    }
}