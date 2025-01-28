package com.flameshine.nebula.structures;

/**
 * For the sake of simplicity, an integer type was used.
 * However, if you want to generify the structure, you can employ compareTo() method.
 */
public class BST {

    private Node root;
    private int size;

    public BST() {
        this.size = 0;
    }

    /**
     * Inserts a node with the specified data into the Binary Search Tree.
     *
     * The main mission of this function is to call another helper one that recursively inserts a new node.
     */
    public void insert(int data) {
        root = insertHelper(root, data);
        ++size;
    }

    /**
     * Deletes the node with the specified data from the Binary Search Tree.
     *
     * The main mission of this function is to call another helper one that recursively deletes a new node.
     */
    public void delete(int data) {
        root = deleteHelper(root, data);
        --size;
    }

    /**
     * Search for the node with the specified data in the Binary Search Tree.
     *
     * 1. First, we check if the tree is not empty. If so, return null.
     * 2. Then, search for the insert position based on the node values:
     *   - If the data of the visited node is less than the specified one, move to the left child.
     *   - If greater - move to the right one.
     *   - Otherwise, stop and return the node found
     * 3. Return null, as there were no such node found in the tree.
     *
     * Runtime complexity - O(log(n)) (if the Binary Search Tree is balanced).
     *
     * @return Node with the specified value, and null otherwise.
     */
    public Node search(int data) {

        if (root == null) {
            return null;
        }

        var current = root;

        while (current != null) {
            if (data < current.data) {
                current = current.left;
            } else if (data > current.data) {
                current = current.right;
            } else {
                return current;
            }
        }

        return null;
    }

    /**
     * Returns the size of the Binary Search Tree.
     *
     * Runtime complexity - O(1).
     *
     * @return The value representing the size of the tree.
     */
    public int size() {
        return size;
    }

    /**
     * Specifies whether the Binary Search Tree is empty or not.
     *
     * Runtime complexity - O(1).
     *
     * @return True if the tree is empty, false otherwise.
     */
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        var accumulator = new StringBuilder();
        toStringHelper(root, accumulator);
        return accumulator.toString();
    }

    /**
     * A helper function that inserts a new node in a tree employing recursion.
     *
     * 1. Check if the current node is null and insert the new one there.
     * 2. Recur down the tree, according to the general binary search tree traversal rules:
     *   - If the specified data is less, go to the left subtree.
     *   - If greater - to the right one.
     *   - Otherwise, simply return the unchanged node pointer.
     *
     * Runtime complexity - O(log(n)) (if the Binary Search Tree is balanced).
     */
    private static Node insertHelper(Node current, int data) {

        if (current == null) {
            return new Node(data);
        }

        if (data < current.data) {
            current.left = insertHelper(current.left, data);
        } else if (data > current.data) {
            current.right = insertHelper(current.right, data);
        }

        return current;
    }

    /**
     * A helper function that deletes a node from a tree using a recursive approach.
     *
     * 1. Check if the current node is present and return null otherwise (there is nothing to delete)
     * 2. Check the children:
     *   - If there are no children - just delete
     *   - If there is a single child - copy that child to the node
     *   - If there are two children - determine the next highest element (inorder successor) in a right subtree and swap it with the current node. Remove the inorder successor duplicate.
     *
     * Runtime complexity - O(log(n)) (if the Binary Search Tree is balanced).
     */
    private static Node deleteHelper(Node current, int data) {

        if (current == null) {
            return null;
        }

        if (data < current.data) {
            current.left = deleteHelper(current.left, data);
        } else if (data > current.data) {
            current.right = deleteHelper(current.right, data);
        } else {

            if (current.left == null) {
                return current.right;
            } else if (current.right == null) {
                return current.left;
            }

            current.data = inorderSuccessor(current.right);
            current.right = deleteHelper(current.right, current.data);
        }

        return current;
    }

    /**
     * A helper function that finds a minimum data in the subtree.
     *
     * Runtime complexity - O(h), where h is the height of the left branch of the subtree received.
     *
     * @return The minimum value in the Binary Search Tree subtree.
     */
    private static int inorderSuccessor(Node current) {

        while (current.left != null) {
            current = current.left;
        }

        return current.data;
    }

    /**
     * A helper function the performs inorder traversal and accumulates the result.
     *
     * Runtime complexity - O(n).
     */
    private static void toStringHelper(Node current, StringBuilder accumulator) {

        if (current == null) {
            return;
        }

        toStringHelper(current.left, accumulator);
        accumulator.append(current.data);
        toStringHelper(current.right, accumulator);
    }

    private static class Node {

        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}