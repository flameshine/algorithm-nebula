class Solution {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        var startPath = traverseBuildingPathToTarget(root, startValue, new StringBuilder());
        var destPath = traverseBuildingPathToTarget(root, destValue, new StringBuilder());
        var i = 0;

        for (; i < Math.min(startPath.length(), destPath.length()); i++) {
            if (startPath.charAt(i) != destPath.charAt(i)) {
                break;
            }
        }

        return "U".repeat(startPath.length() - i) + destPath.substring(i);
    }

    private static String traverseBuildingPathToTarget(
        TreeNode node,
        int target,
        StringBuilder pathBuilder
    ) {

        if (node == null) {
            return null;
        }

        if (node.val == target) {
            return pathBuilder.toString();
        }

        pathBuilder.append("L");

        var leftPath = traverseBuildingPathToTarget(node.left, target, pathBuilder);

        if (leftPath != null) {
            return leftPath;
        }

        pathBuilder.setLength(pathBuilder.length() - 1);
        pathBuilder.append("R");

        var rightPath = traverseBuildingPathToTarget(node.right, target, pathBuilder);

        if (rightPath != null) {
            return rightPath;
        }

        pathBuilder.setLength(pathBuilder.length() - 1);

        return null;
    }
}