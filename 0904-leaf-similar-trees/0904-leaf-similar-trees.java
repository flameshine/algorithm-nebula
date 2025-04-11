class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        
        List<Integer> root1Leaves = new ArrayList<>();
        List<Integer> root2Leaves = new ArrayList<>();

        accumulateLeaves(root1, root1Leaves);
        accumulateLeaves(root2, root2Leaves);

        return root1Leaves.equals(root2Leaves);
    }

    private static void accumulateLeaves(TreeNode root, List<Integer> accumulator) {

        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            accumulator.add(root.val);
        }

        accumulateLeaves(root.left, accumulator);
        accumulateLeaves(root.right, accumulator);
    }
}