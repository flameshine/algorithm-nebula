package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree;

/**
 * №100 Same Tree
 *
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {

    public static void main(String... args) {

        var root1 = new TreeNode(1);
        var root2 = new TreeNode(1);

        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);

        System.out.println(
            isSameTree(root1, root2)
        );
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == null && q == null;
        }

        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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