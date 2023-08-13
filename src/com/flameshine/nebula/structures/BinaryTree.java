package com.flameshine.nebula.structures;

import java.util.Queue;
import java.util.LinkedList;

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

    public void remove(T data) {

    }

    public Node<T> get(T data) {

    }

    public int size() {

    }

    @Override
    public String toString() {
        var builder = new StringBuilder();
        inorderTraversal(root, builder);
        return builder.toString();
    }

    /**
     * Helper method to traversal a tree using in-order approach.
     */
    private void inorderTraversal(Node<T> current, StringBuilder builder) {

        if (current == null) {
            return;
        }

        inorderTraversal(current.left, builder);

        builder.append(current.data);

        inorderTraversal(current.right, builder);
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