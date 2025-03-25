class Solution {
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        var graph = buildGraph(equations, values);
        var result = new double[queries.size()];

        for (var i = 0; i < queries.size(); i++) {

            var dividend = queries.get(i).get(0);
            var divisor = queries.get(i).get(1);
            
            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1d;
            } else {
                Set<String> visited = new HashSet<>();
                var accumulator = new double[] { -1d };
                var tmp = 1d;
                dfs(dividend, divisor, graph, visited, accumulator, tmp);
                result[i] = accumulator[0];
            }
        }

        return result;
    }

    private static Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> result = new HashMap<>();

        for (var i = 0; i < equations.size(); i++) {

            var dividend = equations.get(i).get(0);
            var divisor = equations.get(i).get(1);
            var value = values[i];

            result.putIfAbsent(dividend, new HashMap<>());
            result.putIfAbsent(divisor, new HashMap<>());
            result.get(dividend).put(divisor, value);
            result.get(divisor).put(dividend, 1d / value);
        }

        return result;
    }

    private static void dfs(String node, String destination, Map<String, Map<String, Double>> graph, Set<String> visited, double[] accumulator, double tmp) {
        if (visited.contains(node)) {
            return;
        }

        visited.add(node);

        if (node.equals(destination)) {
            accumulator[0] = tmp;
            return;
        }

        for (var e : graph.get(node).entrySet()) {
            var value = e.getValue() * tmp;
            dfs(e.getKey(), destination, graph, visited, accumulator, value);
        }
    }
}