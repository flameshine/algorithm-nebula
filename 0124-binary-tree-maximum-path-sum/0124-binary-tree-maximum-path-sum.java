class Solution {

    public int maxPathSum(TreeNode root) {
        var result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxPathSum(root, result);
        return result[0];
    }

    private static int maxPathSum(TreeNode root, int[] result) {

        if (root == null) {
            return 0;
        }

        var left = Math.max(maxPathSum(root.left, result), 0);
        var right = Math.max(maxPathSum(root.right, result), 0);

        result[0] = Math.max(result[0], root.val + left + right);

        return root.val + Math.max(left, right);
    }
}