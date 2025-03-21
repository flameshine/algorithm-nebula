class Solution {

    public int findCircleNum(int[][] isConnected) {
        
        var visited = new boolean[isConnected.length];
        var result = 0;

        for (var i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                ++result;
            }
        }

        return result;
    }

    private static void dfs(int[][] isConnected, int i, boolean[] visited) {

        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (var j = 0; j < isConnected.length; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, j, visited);
            }
        }
    }
}