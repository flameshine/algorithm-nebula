package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree_general;

/**
 * №104 Maximum Depth of Binary Tree
 *
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

    public static void main(String... args) {

        var root = new TreeNode(3);
        var rightNode = new TreeNode(20);

        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);
        root.left = new TreeNode(9);
        root.right = rightNode;

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

    static class TreeNode {

        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}