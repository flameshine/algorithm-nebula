class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {

        if (root == null) {
            return List.of();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            var size = queue.size();

            List<Integer> level = new ArrayList<>(size);

            for (var i = 0; i < size; i++) {

                var node = queue.poll();

                level.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }
}