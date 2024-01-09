package com.flameshine.nebula.problems.leetcode.learn.hash_table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * №652 Find Duplicate Subtrees
 *
 * Given the root of a binary tree, return all duplicate subtrees.
 * For each kind of duplicate subtrees, you only need to return the root node of any one of them.
 * Two trees are duplicate if they have the same structure with the same node values.
 */
public class FindDuplicateSubtrees {

    public static void main(String... args) {

        var left = new TreeNode(1);
        var right = new TreeNode(1);
        var root = new TreeNode(2, left, right);

        System.out.println(
            findDuplicateSubtrees(root)
        );
    }

    private static List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> subtreeCount = new HashMap<>();
        List<TreeNode> resultAccumulator = new ArrayList<>();
        encode(root, subtreeCount, resultAccumulator);
        return resultAccumulator;
    }

    private static String encode(TreeNode current, Map<String, Integer> subtreeCount, List<TreeNode> resultAccumulator) {

        if (current == null) {
            return "";
        }

        var left = encode(current.left, subtreeCount, resultAccumulator);
        var right = encode(current.right, subtreeCount, resultAccumulator);
        var encoded = String.join("#", String.valueOf(current.val), left, right);

        subtreeCount.merge(encoded, 1, Integer::sum);

        if (subtreeCount.get(encoded) == 2) {
            resultAccumulator.add(current);
        }

        return encoded;
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
    }
}