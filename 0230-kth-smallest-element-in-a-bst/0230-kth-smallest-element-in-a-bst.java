class Solution {

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        return values.get(k - 1);
    }

    private static void inorder(TreeNode root, List<Integer> values) {

        if (root == null) {
            return;
        }

        inorder(root.left, values);

        values.add(root.val);

        inorder(root.right, values);
    }
}