class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        var counter = new AtomicInteger();
        dfs(root, targetSum, counter);
        return counter.get();
    }

    private static void dfs(
        TreeNode root,
        int targetSum,
        AtomicInteger counter
    ) {

        if (root == null) {
            return;
        }

        traversePath(root, 0, targetSum, counter);
        dfs(root.left, targetSum, counter);
        dfs(root.right, targetSum, counter);
    }

    private static void traversePath(
        TreeNode root,
        long current,
        int target,
        AtomicInteger counter
    ) {

        if (root == null) {
            return;
        }

        var newSum = current + root.val;

        if (newSum == target) {
            counter.incrementAndGet();
        }

        traversePath(root.left, newSum, target, counter);
        traversePath(root.right, newSum, target, counter);
    }
}