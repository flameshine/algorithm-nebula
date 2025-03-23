class Solution {

    public int nearestExit(char[][] maze, int[] entrance) {
        
        var n = maze.length;
        var m = maze[0].length;
        var directions = new int[][] { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
        var visited = new boolean[n][m];

        visited[entrance[0]][entrance[1]] = true;

        Queue<int[]> queue = new LinkedList<>();

        queue.add(entrance);

        var steps = 0;

        while (!queue.isEmpty()) {

            var size = queue.size();
            
            ++steps;

            for (var i = 0; i < size; i++) {

                var node = queue.poll();
                
                for (var j = 0; j < directions.length; j++) {

                    var x = node[0] + directions[j][0];
                    var y = node[1] + directions[j][1];

                    if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y] && maze[x][y] == '.') {
                        queue.add(new int[] {x, y});
                        visited[x][y] = true;
                        if (x == 0 || y == 0 || x == n - 1 || y == m - 1) {
                            return steps;
                        }
                    }
                }
            }
        }

        return -1;
    }
}