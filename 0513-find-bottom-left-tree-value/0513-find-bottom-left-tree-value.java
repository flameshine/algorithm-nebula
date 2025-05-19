class Solution {

    public int findBottomLeftValue(TreeNode root) {
        var resultContainer = new int[1];
        findBottomLeftValue(root, 0, new AtomicInteger(-1), resultContainer);
        return resultContainer[0];
    }

    private static void findBottomLeftValue(
        TreeNode node,
        int depth,
        AtomicInteger maxDepth,
        int[] resultContainer
    ) {

        if (node == null) {
            return;
        }

        if (depth > maxDepth.get()) {
            maxDepth.set(depth);
            resultContainer[0] = node.val;
        }

        findBottomLeftValue(node.left, depth + 1, maxDepth, resultContainer);
        findBottomLeftValue(node.right, depth + 1, maxDepth, resultContainer);
    }
}