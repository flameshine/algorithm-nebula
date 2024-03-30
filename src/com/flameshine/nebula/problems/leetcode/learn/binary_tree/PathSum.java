package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

/**
 * №112 Path Sum
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */
public class PathSum {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            hasPathSum(root, 3)
        );
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        var newTarget = targetSum - root.val;

        if (root.left == null && root.right == null && newTarget == 0) {
            return true;
        }

        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
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