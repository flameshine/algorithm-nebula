package com.flameshine.nebula.structures;

public class CircularQueue {

    private static final int DEFAULT_CAPACITY = 10;

    private final int capacity;

    private Node head;
    private Node tail;
    private int size;

    public CircularQueue() {
        this(DEFAULT_CAPACITY);
    }

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        this.size = 0;
    }

    /**
     * Enqueues an element.
     *
     * 1. Ensure we didn't run out of capacity first.
     * 2. Then, we need to check if the head of the queue is null or not:
     *    - If it is, set an element as a head.
     *    - Otherwise, re-link the elements, placing the element to add as a new tail.
     *
     * Runtime complexity - O(1).
     */
    public boolean enqueue(int value) {

        if (size == capacity) {
            return false;
        }

        var node = new Node(value);

        if (head == null) {
            head = node;
            tail = node;
            tail.previous = head;
        } else {
            var previousTail = tail;
            previousTail.next = node;
            node.previous = previousTail;
            tail = node;
        }

        tail.next = head;

        ++size;

        return true;
    }

    /**
     * Dequeues an element from the front of the queue.
     *
     * 1. Verify that the head isn't null.
     * 2. Check if the size is equal to 1.
     *    If so, zero both head and tail.
     *    Otherwise, unlink the node to delete.
     * 3. Decrement the size and return the saved result.
     *
     * Runtime complexity - O(1).
     *
     * @return An element from the tail of the queue.
     */
    public boolean dequeue() {

        if (head == null) {
            return false;
        }

        if (size == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            tail.next = head;
            head.previous = tail;
        }

        --size;

        return true;
    }

    /**
     * Gets the front item from the queue.
     *
     * 1. Check if the queue is empty.
     *    If so, return -1.
     * 2. Return the head value.
     *
     * Runtime complexity - O(1).
     *
     * @return The queue's front item.
     */
    public int front() {

        if (head == null) {
            return -1;
        }

        return head.data;
    }

    /**
     * Gets the rear item from the queue.
     *
     * 1. Check if the queue is empty.
     *    If so, return -1.
     * 2. Return the head value.
     *
     * Runtime complexity - O(1).
     *
     * @return The queue's rear item.
     */
    public int rear() {

        if (head == null) {
            return -1;
        }

        return tail.data;
    }

    /**
     * Checks if the queue is empty or not.
     *
     * Runtime complexity - O(1).
     *
     * @return True if the queue is empty and false otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks if the queue is full or not.
     *
     * Runtime complexity - O(1).
     *
     * @return True if the queue is full and false otherwise.
     */
    public boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {

        var builder = new StringBuilder("[");
        var pointer = head;

        for (var i = 0; i < size; i++) {
            builder.append(pointer.data);
            if (i != size - 1) {
                builder.append(", ");
            }
            pointer = pointer.next;
        }

        return builder.append("]").toString();
    }

    private static class Node {

        private final int data;

        private Node next;
        private Node previous;

        public Node(int data) {
            this.data = data;
        }
    }
}