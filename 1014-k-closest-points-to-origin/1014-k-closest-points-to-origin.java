class Solution {

    public int[][] kClosest(int[][] points, int k) {
        
        Queue<int[]> heap = new PriorityQueue<>(Solution::euclideanDistance);

        for (var p : points) {

            heap.offer(p);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        var result = new int[k][2];

        while (k > 0) {
            result[--k] = heap.poll();
        }

        return result;
    }

    private static int euclideanDistance(int[] a, int[] b) {
        return b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1];
    }
}