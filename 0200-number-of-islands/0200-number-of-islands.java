class Solution {

    public int numIslands(char[][] grid) {

        var islands = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++islands;
                    clearRestOfTheLand(grid, i, j);
                }
            }
        }

        return islands;
    }

    private static void clearRestOfTheLand(char[][] grid, int i, int j) {

        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        clearRestOfTheLand(grid, i + 1, j);
        clearRestOfTheLand(grid, i - 1, j);
        clearRestOfTheLand(grid, i, j + 1);
        clearRestOfTheLand(grid, i, j - 1);
    }
}