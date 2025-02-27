class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversal(root, result);
        return result;
    }

    private static void inorderTraversal(TreeNode root, List<Integer> accumulator) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left, accumulator);

        accumulator.add(root.val);

        inorderTraversal(root.right, accumulator);
    }
}