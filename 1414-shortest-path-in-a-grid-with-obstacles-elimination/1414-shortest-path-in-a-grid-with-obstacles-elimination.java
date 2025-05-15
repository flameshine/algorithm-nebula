class Solution {

    private static final int[][] DIRECTIONS = {{1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 }};

    public int shortestPath(int[][] grid, int k) {
        
        var m = grid.length;
        var n = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] { 0, 0, 0 });

        var visited = new int[m][n];

        for (var i : visited) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        visited[0][0] = 0;

        var distance = 0;

        while (!queue.isEmpty()) {

            var size = queue.size();

            while (size-- > 0) {

                var current = queue.poll();

                if (current[0] == m - 1 && current[1] == n - 1) {
                    return distance;
                }

                for (var direction : DIRECTIONS) {

                    var newX = current[0] + direction[0];
                    var newY = current[1] + direction[1];

                    if (newX < 0 || newY < 0 || newX >= m || newY >= n) {
                        continue;
                    }

                    var newK = current[2] + grid[newX][newY];

                    if (newK > k) {
                        continue;
                    }

                    if (visited[newX][newY] <= newK) {
                        continue;
                    }

                    visited[newX][newY] = newK;

                    queue.offer(new int[] { newX, newY, newK });
                }
            }

            ++distance;
        }

        return -1;
    }
}