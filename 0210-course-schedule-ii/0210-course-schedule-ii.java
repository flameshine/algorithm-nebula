class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<List<Integer>> graph = new ArrayList<>();

        for (var i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (var prerequisite : prerequisites) {
            graph.get(prerequisite[0]).add(prerequisite[1]);
        }

        List<Integer> resultBuilder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();

        for (var i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, resultBuilder, visited, cycle)) {
                return new int[0];
            }
        }

        return resultBuilder.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }

    private static boolean dfs(
        int current,
        List<List<Integer>> graph,
        List<Integer> resultBuilder,
        Set<Integer> visited,
        Set<Integer> cycle
    ) {

        if (cycle.contains(current)) {
            return false;
        }

        if (visited.contains(current)) {
            return true;
        }

        cycle.add(current);

        for (var prerequisite : graph.get(current)) {
            if (!dfs(prerequisite, graph, resultBuilder, visited, cycle)) {
                return false;
            }
        }

        cycle.remove(current);
        visited.add(current);
        resultBuilder.add(current);

        return true;
    }
}