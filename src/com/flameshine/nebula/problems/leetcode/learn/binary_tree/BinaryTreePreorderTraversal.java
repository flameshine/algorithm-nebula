package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * №144 Binary Tree Preorder Traversal
 *
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            preorderTraversal(root)
        );
    }

    private static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalAccumulating(root, result);
        return result;
    }

    private static void preorderTraversalAccumulating(TreeNode node, List<Integer> accumulator) {

        if (node == null) {
            return;
        }

        accumulator.add(node.val);

        preorderTraversalAccumulating(node.left, accumulator);
        preorderTraversalAccumulating(node.right, accumulator);
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