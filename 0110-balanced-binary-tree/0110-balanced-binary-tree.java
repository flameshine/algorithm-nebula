class Solution {

    public boolean isBalanced(TreeNode root) {
        
        if (root == null) {
            return true;
        }

        var height = calculateHeightCheckingForBalance(root);

        return height != -1;
    }

    private static int calculateHeightCheckingForBalance(TreeNode node) {

        if (node == null) {
            return 0;
        }

        var left = calculateHeightCheckingForBalance(node.left);
        var right = calculateHeightCheckingForBalance(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}