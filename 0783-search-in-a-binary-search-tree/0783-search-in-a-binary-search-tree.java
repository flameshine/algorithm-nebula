class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        
        var pointer = root;

        while (pointer != null) {
            if (pointer.val > val) {
                pointer = pointer.left;
            } else if (pointer.val < val) {
                pointer = pointer.right;
            } else {
                return pointer;
            }
        }

        return null;
    }
}