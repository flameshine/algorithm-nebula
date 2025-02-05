class Solution {

    public TreeNode invertTree(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {

            var current = queue.poll();

            if (current != null) {

                queue.add(current.left);
                queue.add(current.right);

                var tmp = current.left;

                current.left = current.right;
                current.right = tmp;
            }
        }

        return root;
    }
}