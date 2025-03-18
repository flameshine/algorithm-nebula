class Solution {

    public String predictPartyVictory(String senate) {
        
        var n = senate.length();

        Queue<Integer> radiants = new LinkedList<>();
        Queue<Integer> dires = new LinkedList<>();

        for (var i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiants.add(i);
            } else {
                dires.add(i);
            }
        }

        while (!radiants.isEmpty() && !dires.isEmpty()) {
            
            if (radiants.peek() < dires.peek()) {
                radiants.add(n++);
            } else {
                dires.add(n++);
            }

            radiants.poll();
            dires.poll();
        }

        return radiants.isEmpty() ? "Dire" : "Radiant";
    }
}