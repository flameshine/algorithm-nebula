class Solution {

    public boolean isBalanced(TreeNode root) {
        return calculateHeightCheckingIfBalanced(root) != -1;
    }

    private static int calculateHeightCheckingIfBalanced(TreeNode node) {

        if (node == null) {
            return 0;
        }

        var left = calculateHeightCheckingIfBalanced(node.left);
        var right = calculateHeightCheckingIfBalanced(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}