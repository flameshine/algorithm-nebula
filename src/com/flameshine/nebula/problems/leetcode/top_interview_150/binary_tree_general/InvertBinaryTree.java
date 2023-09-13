package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree_general;

import java.util.LinkedList;
import java.util.Queue;

/**
 * №226 Invert Binary Tree
 *
 * Given the root of a binary tree, invert the tree, and return its root.
 */
public class InvertBinaryTree {

    public static void main(String... args) {

        var root = new TreeNode(1);

        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(
            invertTree(root)
        );
    }

    private static TreeNode invertTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current != null) {
                queue.add(current.left);
                queue.add(current.right);
                var temporary = current.left;
                current.left = current.right;
                current.right = temporary;
            }
        }

        return root;
    }

    static class TreeNode {

        private final int val;

        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}