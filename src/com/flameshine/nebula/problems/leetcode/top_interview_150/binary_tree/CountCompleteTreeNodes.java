package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * №222 Count Complete Tree Nodes
 *
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible.
 * It can have between 1 and 2^h nodes inclusive at the last level h.
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class CountCompleteTreeNodes {

    public static void main(String... args) {

        var root = new TreeNode(1);
        var leftNode = new TreeNode(2);
        var rightNode = new TreeNode(3);

        leftNode.left = new TreeNode(4);
        leftNode.right = new TreeNode(5);
        rightNode.left = new TreeNode(6);
        root.left = leftNode;
        root.right = rightNode;

        System.out.println(
            countNodes(root)
        );
    }

    private static int countNodes(TreeNode root) {
        var counter = new AtomicInteger(0);
        countNodes(root, counter);
        return counter.get();
    }

    private static void countNodes(TreeNode root, AtomicInteger counter) {

        if (root == null) {
            return;
        }

        countNodes(root.left, counter);

        counter.incrementAndGet();

        countNodes(root.right, counter);
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