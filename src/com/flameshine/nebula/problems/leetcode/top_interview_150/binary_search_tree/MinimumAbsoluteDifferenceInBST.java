package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_search_tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * №530 Minimum Absolute Difference in BST
 *
 * Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.
 */
public class MinimumAbsoluteDifferenceInBST {

    public static void main(String... args) {

        var root = new TreeNode(4);
        var leftNode = new TreeNode(2);

        leftNode.left = new TreeNode(1);
        leftNode.right = new TreeNode(3);
        root.left = leftNode;
        root.right = new TreeNode(6);

        System.out.println(
            getMinimumDifference(root)
        );
    }

    private static int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return 0;
        }

        Deque<TreeNode> stack = new LinkedList<>();

        var result = Integer.MAX_VALUE;

        TreeNode previous = null;
        TreeNode current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            if (previous != null) {
                result = Math.min(result, current.val - previous.val);
            }

            previous = current;
            current = current.right;
        }

        return result;
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