class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        Queue<Car> heap = new PriorityQueue<>((a, b) -> b.position - a.position);

        for (var i = 0; i < position.length; i++) {
            heap.add(new Car(position[i], speed[i]));
        }

        double slowest = 0;
        var result = 0;

        while (!heap.isEmpty()) {

            var car = heap.poll();
            var time = (double) (target - car.position) / car.speed;

            if (slowest < time) {
                slowest = time;
                ++result;
            }
        }

        return result;
    }

    private record Car(int position, int speed) {}
}