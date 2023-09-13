package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree_general;

/**
 * №101 Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    public static void main(String... args) {

        var root = new TreeNode(1);
        var leftNode = new TreeNode(2);
        var rightNode = new TreeNode(2);

        leftNode.left = new TreeNode(3);
        leftNode.right = new TreeNode(4);
        rightNode.left = new TreeNode(4);
        rightNode.right = new TreeNode(3);
        root.left = leftNode;
        root.right = rightNode;

        System.out.println(
            isSymmetric(root)
        );
    }

    private static boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private static boolean isSymmetric(TreeNode left, TreeNode right) {

        if (left == null || right == null) {
            return left == right;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
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