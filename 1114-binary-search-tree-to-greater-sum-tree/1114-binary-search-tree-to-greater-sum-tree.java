class Solution {

    public TreeNode bstToGst(TreeNode root) {
        return bstToGst(root, new AtomicInteger());
    }

    private static TreeNode bstToGst(TreeNode root, AtomicInteger sum) {
        
        if (root == null) {
            return null;
        }

        bstToGst(root.right, sum);

        sum.getAndUpdate(i -> i + root.val);

        root.val = sum.get();

        bstToGst(root.left, sum);

        return root;
    }
}