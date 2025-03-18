class Solution {

    public int longestZigZag(TreeNode root) {
        return dfs(root, 0, 0);
    }

    private static int dfs(TreeNode root, int left, int right) {

        if (root == null) {
            return Math.max(left, right) - 1;
        }

        var bestLeft = dfs(root.left, right + 1, 0);
        var bestRight = dfs(root.right, 0, left + 1);

        return Math.max(bestLeft, bestRight);
    }
}