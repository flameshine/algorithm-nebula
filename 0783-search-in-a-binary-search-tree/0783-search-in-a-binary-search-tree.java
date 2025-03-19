class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        
        var pointer = root;

        while (pointer != null && pointer.val != val) {
            if (pointer.val > val) {
                pointer = pointer.left;
            } else {
                pointer = pointer.right;
            }
        }

        return pointer;
    }
}