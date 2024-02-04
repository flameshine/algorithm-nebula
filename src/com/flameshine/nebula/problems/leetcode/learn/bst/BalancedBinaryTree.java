package com.flameshine.nebula.problems.leetcode.learn.bst;

/**
 * №110 Balanced Binary Tree
 *
 * Given a binary tree, determine if it is height-balanced.
 */
public class BalancedBinaryTree {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            isBalanced(root)
        );
    }

    private static boolean isBalanced(TreeNode root) {

        if (root == null) {
            return true;
        }

        var height = calculateHeight(root);

        return height != -1;
    }

    private static int calculateHeight(TreeNode root) {

        if (root == null) {
            return 0;
        }

        var leftHeight = calculateHeight(root.left);
        var rightHeight = calculateHeight(root.right);

        if (leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
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