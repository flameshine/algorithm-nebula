package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree;

/**
 * №112 Path Sum
 *
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */
public class PathSum {

    public static void main(String... args) {

        var root = new TreeNode(1);
        var leftNode = new TreeNode(2);

        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(4);
        root.left = leftNode;
        root.right = new TreeNode(5);

        System.out.println(
            hasPathSum(root, 6)
        );
    }

    private static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && targetSum - root.val == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}