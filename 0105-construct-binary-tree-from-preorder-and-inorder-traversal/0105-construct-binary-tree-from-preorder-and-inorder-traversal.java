class Solution {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inorderMap = new HashMap<>();

        for (var i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorderMap, 0, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap, int rootIndex, int left, int right) {

        if (left > right) {
            return null;
        }

        var root = new TreeNode(preorder[rootIndex]);
        var mid = inorderMap.get(preorder[rootIndex]);

        root.left = buildTree(preorder, inorderMap, rootIndex + 1, left, mid - 1);
        root.right = buildTree(preorder, inorderMap, rootIndex + mid - left + 1, mid + 1, right);

        return root;
    }
}