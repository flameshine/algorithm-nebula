class Solution {

    public boolean isValidBST(TreeNode root) {
        
        if (root == null) {
            return true;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode previous = null;

        while (root != null || !stack.isEmpty()) {

            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();

            if (previous != null && root.val <= previous.val) {
                return false;
            }
            
            previous = root;
            root = root.right;
        }

        return true;
    }
}