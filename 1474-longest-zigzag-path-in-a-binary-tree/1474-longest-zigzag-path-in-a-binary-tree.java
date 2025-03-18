class Solution {

    public int longestZigZag(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        var maxLength = new int[1];

        dfs(root, true, maxLength, 0);

        return maxLength[0];
    }

    private static void dfs(
        TreeNode node,
        boolean isLeft,
        int[] maxLength,
        int currentLength
    ) {

        if (node == null) {
            return;
        }

        maxLength[0] = Math.max(maxLength[0], currentLength);

        if (isLeft) {
            dfs(node.left, false, maxLength, currentLength + 1);
            dfs(node.right, true, maxLength, 1);
        } else {
            dfs(node.right, true, maxLength, currentLength + 1);
            dfs(node.left, false, maxLength, 1);
        }
    }
}