class Solution {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null) {
            return false;
        }
        
        return isSameTree(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode one, TreeNode another) {

        if (one == null && another == null) {
            return true;
        }

        if (one == null || another == null) {
            return false;
        }

        if (one.val != another.val) {
            return false;
        }

        return isSameTree(one.left, another.left) && isSameTree(one.right, another.right);
    }
}