package com.flameshine.nebula.problems.leetcode.top_interview_150.binary_tree_bfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * №637 Average of Levels in Binary Tree
 *
 * Given the root of a binary tree, return the average value of the nodes on each level in the form of an array.
 * Answers within 10^(-5) of the actual answer will be accepted.
 */
public class AverageOfLevelsInBinaryTree {

    public static void main(String... args) {

        var root = new TreeNode(3);
        var rightNode = new TreeNode(20);

        rightNode.left = new TreeNode(15);
        rightNode.right = new TreeNode(7);
        root.left = new TreeNode(9);
        root.right = rightNode;

        System.out.println(
            averageOfLevels(root)
        );
    }

    private static List<Double> averageOfLevels(TreeNode root) {

        List<Double> result = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            var size = queue.size();
            var sum = 0d;

            for (var i = 0; i < size; i++) {

                var current = queue.poll();

                sum += current.val;

                if (current.left != null) {
                    queue.offer(current.left);
                }

                if (current.right != null) {
                    queue.offer(current.right);
                }
            }

            result.add(sum / size);
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