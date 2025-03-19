class Solution {

    public int maxLevelSum(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        var maxSum = Integer.MIN_VALUE;
        var level = 0;
        var result = 0;

        while (!queue.isEmpty()) {

            ++level;

            var size = queue.size();
            var sum = 0;

            for (var i = 0; i < size; i++) {

                var node = queue.poll();

                sum += node.val;

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            if (sum > maxSum) {
                maxSum = sum;
                result = level;
            }
        }

        return result;
    }
}