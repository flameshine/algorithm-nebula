class Solution {

    public int findCircleNum(int[][] isConnected) {
        
        var visited = new boolean[isConnected.length];
        var result = 0;

        for (var i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                ++result;
            }
        }

        return result;
    }

    private static void dfs(int[][] isConnected, boolean[] visited, int i) {

        if (visited[i]) {
            return;
        }

        visited[i] = true;

        for (var j = 0; j < isConnected[0].length; j++) {
            if (isConnected[i][j] == 1) {
                dfs(isConnected, visited, j);
            }
        }
    }
}