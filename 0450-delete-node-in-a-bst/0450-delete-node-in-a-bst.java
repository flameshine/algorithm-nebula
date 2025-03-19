class Solution {
    
    public TreeNode deleteNode(TreeNode root, int key) {
        
        if (root == null) {
            return null;
        }

        if (key > root.val) {
            root.right = deleteNode(root.right, key);
            return root;
        } else if (key < root.val) {
            root.left = deleteNode(root.left, key);
            return root;
        } else {

            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            root.val = inorderSuccessor(root.right);
            root.right = deleteNode(root.right, root.val);
            
            return root;
        }
    }

    private static int inorderSuccessor(TreeNode current) {

        while (current.left != null) {
            current = current.left;
        }

        return current.val;
    }
}