class Solution {
    
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        Set<Integer> keys = new HashSet<>();
        Queue<Integer> roomsToVisit = new LinkedList<>();

        keys.add(0);
        roomsToVisit.add(0);

        while (!roomsToVisit.isEmpty()) {

            var room = roomsToVisit.poll();

            for (var key : rooms.get(room)) {
                if (!keys.contains(key)) {
                    roomsToVisit.add(key);
                    keys.add(key);
                }
            }
        }

        return keys.size() == rooms.size();
    }
}