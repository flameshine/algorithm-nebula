package com.flameshine.nebula.problems.leetcode.learn.binary_tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * №102 Binary Tree Level Order Traversal
 *
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLeverOrderTraversal {

    public static void main(String... args) {

        var leaf1 = new TreeNode(1);
        var leaf2 = new TreeNode(3);
        var root = new TreeNode(2, leaf1, leaf2);

        System.out.println(
            levelOrder(root)
        );
    }

    private static List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return List.of();
        }

        List<List<Integer>> result = new ArrayList<>();

        result.add(
            List.of(root.val)
        );

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            List<Integer> level = new ArrayList<>();
            var size = queue.size();

            for (var i = 0; i < size; i++) {

                var current = queue.poll();

                if (current.left != null) {
                    level.add(current.left.val);
                    queue.add(current.left);
                }

                if (current.right != null) {
                    level.add(current.right.val);
                    queue.add(current.right);
                }
            }

            if (!level.isEmpty()) {
                result.add(level);
            }
        }

        return result;
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