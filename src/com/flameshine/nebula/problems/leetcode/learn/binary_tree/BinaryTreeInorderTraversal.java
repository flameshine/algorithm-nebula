package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * №94 Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            inorderTraversal(root)
        );
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalAccumulating(root, result);
        return result;
    }

    private static void inorderTraversalAccumulating(TreeNode node, List<Integer> accumulator) {

        if (node == null) {
            return;
        }

        inorderTraversalAccumulating(node.left, accumulator);

        accumulator.add(node.val);

        inorderTraversalAccumulating(node.right, accumulator);
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

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
        }
    }
}