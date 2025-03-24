class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        Queue<Position> queue = new LinkedList<>();

        var total = 0;
        var rotten = 0;
        var time = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == 1 || grid[i][j] == 2) {
                    ++total;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new Position(i, j));
                }
            }
        }

        if (total == 0) {
            return 0;
        }

        while (!queue.isEmpty() && rotten < total) {

            var size = queue.size();

            rotten += size;

            if (rotten == total) {
                return time;
            }

            ++time;

            for (var i = 0; i < size; i++) {

                var p = queue.peek();

                if (p.x() + 1 < grid.length && grid[p.x() + 1][p.y()] == 1) {
                    grid[p.x() + 1][p.y()] = 2;
                    queue.offer(new Position(p.x() + 1, p.y()));
                }

                if (p.x() - 1 >= 0 && grid[p.x() - 1][p.y()] == 1) {
                    grid[p.x() - 1][p.y()] = 2;
                    queue.offer(new Position(p.x() - 1, p.y()));
                }

                if (p.y() + 1 < grid[0].length && grid[p.x()][p.y() + 1] == 1) {
                    grid[p.x()][p.y() + 1] = 2;
                    queue.offer(new Position(p.x(), p.y() + 1));
                }

                if (p.y() - 1 >= 0 && grid[p.x()][p.y() - 1] == 1) {
                    grid[p.x()][p.y() - 1] = 2;
                    queue.offer(new Position(p.x(), p.y() - 1));
                }

                queue.poll();
            }
        }

        return -1;
    }

    private record Position(int x, int y) {}
}