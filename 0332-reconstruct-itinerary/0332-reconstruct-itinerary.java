class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {

        Map<String, PriorityQueue<String>> flights = new HashMap<>();
        List<String> path = new LinkedList<>();
        
        for (var ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        dfs("JFK", flights, path);

        return path;
    }

    private static void dfs(
        String departure,
        Map<String, PriorityQueue<String>> flights,
        List<String> path
    ) {

        var arrivals = flights.get(departure);

        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, path);
        }

        path.addFirst(departure);
    }
}