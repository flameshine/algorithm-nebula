class Solution {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        var level = 0;

        while (!queue.isEmpty()) {

            var size = queue.size();
            
            List<Integer> current = new ArrayList<>();

            for (var i = 0; i < size; i++) {
                var node = queue.poll();
                if (node != null) {
                    current.add(node.val);
                    queue.add(node.left);
                    queue.add(node.right);
                }
            }

            if (!current.isEmpty()) {

                if (level % 2 == 1) {
                    Collections.reverse(current);
                }

                result.add(current);
            }

            ++level;
        }

        return result;
    }
}