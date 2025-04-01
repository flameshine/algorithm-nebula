class Solution {

    public int numIslands(char[][] grid) {
        
        var result = 0;

        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    ++result;
                    clearRestOfTheIsland(grid, i, j);
                }
            }
        }

        return result;
    }

    private static void clearRestOfTheIsland(char[][] grid, int i, int j) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        clearRestOfTheIsland(grid, i + 1, j);
        clearRestOfTheIsland(grid, i - 1, j);
        clearRestOfTheIsland(grid, i, j + 1);
        clearRestOfTheIsland(grid, i, j - 1);
    }
}