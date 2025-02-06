class Solution {

    public int goodNodes(TreeNode root) {
        var counter = new AtomicInteger(0);
        traverseTreeCountingGoodNodes(root, root.val, counter);
        return counter.get();
    }

    private static void traverseTreeCountingGoodNodes(TreeNode node, int max, AtomicInteger counter) {

        if (node == null) {
            return;
        }

        if (node.val >= max) {
            max = node.val;
            counter.incrementAndGet();
        }

        traverseTreeCountingGoodNodes(node.left, max, counter);
        traverseTreeCountingGoodNodes(node.right, max, counter);
    }
}