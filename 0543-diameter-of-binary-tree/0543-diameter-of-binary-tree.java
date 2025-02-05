class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        var diameter = new int[1];
        computeHeightUpdatingDiameter(root, diameter);
        return diameter[0];
    }

    private static int computeHeightUpdatingDiameter(TreeNode node, int[] diameter) {

        if (node == null) {
            return 0;
        }

        var left = computeHeightUpdatingDiameter(node.left, diameter);
        var right = computeHeightUpdatingDiameter(node.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return Math.max(left, right) + 1;
    }
}