class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);

        for (var point : points) {
            heap.offer(point);
        }

        var result = new int[k][2];
        var i = 0;

        while (k-- > 0) {
            result[i++] = heap.poll();
        }

        return result;
    }

    private static double euclideanDistanceToOrigin(int x, int y) {
        return Math.sqrt(x * x + y * y);
    }
}