class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        if (p == null) {
            return q == null;
        }

        if (q == null) {
            return p == null;
        }

        if (p.val != q.val) {
            return false;
        }

        var left = isSameTree(p.left, q.left);
        var right = isSameTree(p.right, q.right);

        return left && right;
    }
}