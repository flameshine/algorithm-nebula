class Solution {
    
    public int minReorder(int n, int[][] connections) {

        List<List<Pair<Integer, Integer>>> graph = new ArrayList<>();

        for (var i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (var connection : connections) {
            graph.get(connection[0]).add(new Pair<>(connection[1], 1));
            graph.get(connection[1]).add(new Pair<>(connection[0], -1));
        }

        var visited = new boolean[n];
        var result = new int[1];

        dfs(graph, visited, result, 0);

        return result[0];
    }

    private static void dfs(List<List<Pair<Integer, Integer>>> graph, boolean[] visited, int[] result, int current) {
        
        visited[current] = true;

        for (var neighbour : graph.get(current)) {

            var i = neighbour.getKey();

            if (!visited[i]) {

                if (neighbour.getValue() == 1) {
                    ++result[0];
                }

                dfs(graph, visited, result, i);
            }
        }
    }
}