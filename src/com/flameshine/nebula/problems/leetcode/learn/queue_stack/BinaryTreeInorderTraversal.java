package com.flameshine.nebula.problems.leetcode.learn.queue_stack;

import java.util.ArrayList;
import java.util.List;

/**
 * №94 Binary Tree Inorder Traversal
 *
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class BinaryTreeInorderTraversal {

    public static void main(String... args) {

        var root = new TreeNode(1);

        System.out.println(
            inorderTraversal(root)
        );
    }

    private static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> accumulator = new ArrayList<>();
        inorderTraversal(accumulator, root);
        return accumulator;
    }

    private static void inorderTraversal(List<Integer> accumulator, TreeNode node) {

        if (node == null) {
            return;
        }

        inorderTraversal(accumulator, node.left);

        accumulator.add(node.val);

        inorderTraversal(accumulator, node.right);
    }

    private static class TreeNode {

        private final int val;

        private TreeNode left;
        private TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}