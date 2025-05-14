class Solution {

    public List<String> findItinerary(List<List<String>> tickets) {
        
        Map<String, Queue<String>> flights = new HashMap<>();

        for (var ticket : tickets) {
            flights.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            flights.get(ticket.get(0)).add(ticket.get(1));
        }

        List<String> itinerary = new LinkedList<>();

        dfs("JFK", flights, itinerary);

        return itinerary;
    }

    private static void dfs(
        String airport,
        Map<String, Queue<String>> flights,
        List<String> itinerary
    ) {

        var arrivals = flights.get(airport);

        while (arrivals != null && !arrivals.isEmpty()) {
            dfs(arrivals.poll(), flights, itinerary);
        }

        itinerary.addFirst(airport);
    }
}