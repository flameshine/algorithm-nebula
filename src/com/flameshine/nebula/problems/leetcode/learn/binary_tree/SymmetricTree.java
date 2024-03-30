package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

/**
 * №101 Symmetric Tree
 *
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

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

        return isSymmetric(left.left, right.right) &&isSymmetric(left.right, right.left);
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