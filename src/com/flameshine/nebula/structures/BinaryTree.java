package com.flameshine.nebula.structures;

import java.util.Queue;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree() {}

    /**
     * Inserts a value into a binary tree.
     *
     * 1. If the root is null, set the received data as a tree root.
     * 2. Otherwise, create a queue that will hold nodes to visit and populate it with the root node.
     * 3. Check each node queue contains, performing these operations:
     *    - Then, check if the left leaf is null. If so, place the value there.
     *    - Similarly, check if the right leaf is null and place the value there.
     *    - If none of the conditions above are true, add both leafs to the queue.
     */
    public void insert(T data) {

        if (root == null) {
            root = new Node<>(data);
            return;
        }

        Queue<Node<T>> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            var current = queue.poll();

            if (current.left == null) {
                current.left = new Node<>(data);
                return;
            } else if (current.right == null) {
                current.right = new Node<>(data);
                return;
            } else {
                queue.add(current.left);
                queue.add(current.right);
            }
        }
    }

    /**
     * Specifies whether the value exists in the tree or not.
     *
     * 1. Call a helper function that recursively check each node.
     *
     * @return True if the binary tree contains specified data, false otherwise.
     */
    public boolean contains(T data) {
        return contains(root, data);
    }

    /**
     * Calculates size of the binary tree.
     *
     * 1. Create a counter, that will be incremented each time we visited a node.
     * 2. Perform in-order traversal of the tree, incrementing a counter with each node visited.
     * 3. Return the accumulated value.
     *
     * @return Number of nodes in the tree.
     */
    public int size() {
        var counter = new AtomicInteger();
        inorderTraversalActioning(root, ignored -> counter.incrementAndGet());
        return counter.get();
    }

    @Override
    public String toString() {
        var accumulator = new StringBuilder();
        inorderTraversalActioning(root, accumulator::append);
        return accumulator.toString();
    }

    /**
     * Helper method to traverse a tree, performing some action specified.
     */
    private void inorderTraversalActioning(Node<T> current, Consumer<Object> action) {

        if (current == null) {
            return;
        }

        inorderTraversalActioning(current.left, action);

        action.accept(current.data);

        inorderTraversalActioning(current.right, action);
    }

    /**
     * Helper method to recursively check if the value exists.
     *
     * 1. Check if the current node exists. If not, return false.
     * 2. Check if the data current node holds equal to the target data.
     * 3. Continue checking each both branches of the tree.
     */
    private boolean contains(Node<T> current, T data) {

        if (current == null) {
            return false;
        }

        if (current.data.equals(data)) {
            return true;
        }

        return contains(current.left, data) || contains(current.right, data);
    }

    public static class Node<T> {

        private final T data;

        private Node<T> left;
        private Node<T> right;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}