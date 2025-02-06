class Solution {
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSightViewHelper(root, result, 0);
        return result;
    }

    private static void rightSightViewHelper(TreeNode node, List<Integer> accumulator, int level) {

        if (node == null) {
            return;
        }

        if (level == accumulator.size()) {
            accumulator.add(node.val);
        }

        rightSightViewHelper(node.right, accumulator, level + 1);
        rightSightViewHelper(node.left, accumulator, level + 1);
    }
}