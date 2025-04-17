class Solution {

    public void recoverTree(TreeNode root) {
        
        List<Integer> values = new ArrayList<>();
        List<TreeNode> nodes = new ArrayList<>();

        inorderTraversal(root, values, nodes);

        Collections.sort(values);

        for (var i = 0; i < values.size(); i++) {
            nodes.get(i).val = values.get(i);
        }
    }

    private static void inorderTraversal(TreeNode node, List<Integer> values, List<TreeNode> nodes) {

        if (node == null) {
            return;
        }

        inorderTraversal(node.left, values, nodes);

        values.add(node.val);
        nodes.add(node);

        inorderTraversal(node.right, values, nodes);
    }
}