package com.flameshine.nebula.problems.leetcode.learn.bst;

/**
 * №700 Search in a Binary Search Tree
 *
 * You are given the root of a binary search tree (BST) and an integer val.
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node.
 * If such a node does not exist, return null.
 */
public class SearchInABinarySearchTree {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            searchBST(root, 2)
        );
    }

    private static TreeNode searchBST(TreeNode root, int val) {

        var pointer = root;

        while (pointer != null && pointer.val != val) {
            if (pointer.val > val) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }

        return pointer;
    }

    private static class TreeNode {

        private final int val;

        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}