class Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideView(root, result, 0);
        return result;
    }

    private static void rightSideView(
        TreeNode node,
        List<Integer> accumulator,
        int level
    ) {

        if (node == null) {
            return;
        }

        if (level == accumulator.size()) {
            accumulator.add(node.val);
        }

        rightSideView(node.right, accumulator, level + 1);
        rightSideView(node.left, accumulator, level + 1);
    }
}