class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        var pointer = root;

        while (pointer != null) {

            if (pointer.val > p.val && pointer.val > q.val) {
                pointer = pointer.left;
            } else if (pointer.val < p.val && pointer.val < q.val) {
                pointer = pointer.right;
            } else {
                return pointer;
            }
        }

        return null;
    }
}