package com.flameshine.nebula.problems.leetcode.top_interview_150.divide_and_conquer;

/**
 * №108 Convert Sorted Array to Binary Search Tree
 *
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 */
public class ConvertSortedArrayToBST {

    public static void main(String... args) {

        int[] nums = { -10, -3, 0, 5, 9 };

        System.out.println(
            sortedArrayToBST(nums)
        );
    }

    private static TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private static TreeNode sortedArrayToBST(int[] nums, int left, int right) {

        if (left > right) {
            return null;
        }

        if (left == right) {
            return new TreeNode(nums[left]);
        }

        var middle = (left + right) / 2;
        var root = new TreeNode(nums[middle]);

        root.left = sortedArrayToBST(nums, left, middle - 1);
        root.right = sortedArrayToBST(nums, middle + 1, right);

        return root;
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