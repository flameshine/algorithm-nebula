class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        Queue<Map.Entry<Double, int[]>> heap = new PriorityQueue<>(Map.Entry.comparingByKey());

        for (var point : points) {
            
            var entry = Map.entry(
                euclideanDistanceToOrigin(point[0], point[1]),
                point
            );

            heap.offer(entry);
        }

        var result = new int[k][2];
        var i = 0;

        while (k-- > 0) {
            result[i++] = heap.poll().getValue();
        }

        return result;
    }

    private static double euclideanDistanceToOrigin(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
}