package com.flameshine.nebula.structures;

import java.util.Queue;
import java.util.LinkedList;
import java.util.function.Consumer;

public class BinaryTree<T> {

    private Node<T> root;
    private int size;

    public BinaryTree() {
        this.size = 0;
    }

    /**
     * Inserts a value into a binary tree.
     *
     * 1. First, increment a size variable.
     * 2. If the root is null, set the received data as a tree root.
     * 3. Otherwise, create a queue that will hold nodes to visit and populate it with the root node.
     * 4. Check each node queue contains, performing these operations:
     *    - Then, check if the left leaf is null. If so, place the value there.
     *    - Similarly, check if the right leaf is null and place the value there.
     *    - If none of the conditions above are true, add both leafs to the queue.
     *
     * Runtime complexity - O(n).
     */
    public void insert(T data) {

        ++size;

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
     * Returns the value representing the size of the binary tree.
     *
     * Runtime complexity - O(1).
     *
     * @return Number of nodes in the tree.
     */
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        var accumulator = new StringBuilder();
        inorderTraversalActioning(root, accumulator::append);
        return accumulator.toString();
    }

    /**
     * Helper method to traverse a tree, performing some action specified.
     *
     * Note: technically, there is no reason for this method to receive a Consumer interface anymore,
     * but historically this method was also used to calculate the size and eventually was removed
     * in favor of the size variable.
     *
     * Runtime complexity - O(n).
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
     *
     * Runtime complexity - O(n).
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