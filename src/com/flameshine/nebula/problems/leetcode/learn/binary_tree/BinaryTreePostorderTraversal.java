package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

import java.util.ArrayList;
import java.util.List;

/**
 * №145 Binary Tree Postorder Traversal
 *
 * Given the root of a binary tree, return the postorder traversal of its nodes' values.
 */
public class BinaryTreePostorderTraversal {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            postorderTraversal(root)
        );
    }

    private static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalAccumulating(root, result);
        return result;
    }

    private static void postorderTraversalAccumulating(TreeNode node, List<Integer> accumulator) {

        if (node == null) {
            return;
        }

        postorderTraversalAccumulating(node.left, accumulator);
        postorderTraversalAccumulating(node.right, accumulator);

        accumulator.add(node.val);
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