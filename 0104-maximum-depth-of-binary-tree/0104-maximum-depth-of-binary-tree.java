class Solution {

    public int maxDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }

        var left = maxDepth(root.left);
        var right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }
}