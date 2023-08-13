package com.flameshine.nebula.structures;

public class BinaryTree<T> {

    private Node<T> root;

    public BinaryTree() {}

    /**
     * Inserts a value into a binary tree.
     *
     * 1. If the root is null, set the received data as a tree root.
     * 2. Otherwise, call a helper recursive function to find a proper leaf to insert a data.
     */
    public void insert(T data) {
        if (root == null) {
            root = new Node<>(data);
        } else {
            insert(root, data);
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
     * Helper function that inserts the particular leaf.
     *
     * 1. First, check if the left leaf is null. If so, place the value there.
     * 2. Then, check if the right leaf is null and place the value there.
     * 3. If none of the conditions above a true, continue traversing a tree, starting from the left leaf.
     */
    private void insert(Node<T> current, T data) {
        if (current.left == null) {
            current.left = new Node<>(data);
        } else if (current.right == null) {
            current.right = new Node<>(data);
        } else {
            insert(current.left, data);
        }
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