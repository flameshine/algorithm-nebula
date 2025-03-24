class Solution {
    
    public int orangesRotting(int[][] grid) {
        
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    rotAdjacent(grid, i, j, 2);
                }
            }
        }

        var minutes = 2;

        for (var row : grid) {
            for (var cell : row) {

                if (cell == 1) {
                    return -1;
                }

                minutes = Math.max(minutes, cell);
            }
        }

        return minutes - 2;
    }

    private static void rotAdjacent(int[][] grid, int i, int j, int minutes) {

        if (
            i < 0 ||
            i >= grid.length ||
            j < 0 ||
            j >= grid[0].length ||
            grid[i][j] == 0 ||
            (grid[i][j] > 1 && grid[i][j] < minutes)
        ) {
            return;
        }

        grid[i][j] = minutes;

        rotAdjacent(grid, i - 1, j, minutes + 1);
        rotAdjacent(grid, i + 1, j, minutes + 1);
        rotAdjacent(grid, i, j - 1, minutes + 1);
        rotAdjacent(grid, i, j + 1, minutes + 1);
    }
}