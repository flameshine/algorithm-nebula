class Solution {

    public int pathSum(TreeNode root, int targetSum) {
        var counter = new AtomicLong();
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        dfs(root, (long) targetSum, 0L, map, counter);
        return (int) counter.get();
    }

    private static void dfs(
        TreeNode root,
        long target,
        long current,
        Map<Long, Long> map,
        AtomicLong counter
    ) {

        if (root == null) {
            return;
        }

        current += root.val;

        if (map.containsKey(current - target)) {
            counter.getAndAdd(map.get(current - target));
        }

        map.merge(current, 1L, Long::sum);

        dfs(root.left, target, current, map, counter);
        dfs(root.right, target, current, map, counter);

        map.merge(current, -1L, Long::sum);
    }
}