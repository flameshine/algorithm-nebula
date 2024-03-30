package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

/**
 * №104 Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            maxDepth(root)
        );
    }

    private static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        var left = maxDepth(root.left);
        var right = maxDepth(root.right);

        return Math.max(left, right) + 1;
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