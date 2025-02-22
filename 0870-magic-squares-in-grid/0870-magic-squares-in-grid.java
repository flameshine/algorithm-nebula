class Solution {


    public int numMagicSquaresInside(int[][] grid) {
        
        var result = 0;

        for (var i = 0; i <= grid.length - 3; i++) {
            for (var j = 0; j <= grid[0].length - 3; j++) {
                if (isMagicSquare(grid, i, j)) {
                    ++result;
                }
            }
        }

        return result;
    }

    private static boolean isMagicSquare(int[][] grid, int i, int j) {

        var seen = new boolean[10];

        for (var x = 0; x < 3; x++) {
            for (var y = 0; y < 3; y++) {
                var num = grid[i + x][j + y];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        var sum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2];

        for (var x = 0; x < 3; x++) {
            if (sum != grid[i + x][j] + grid[i + x][j + 1] + grid[i + x][j + 2]) {
                return false;
            }
        }

        for (var y = 0; y < 3; y++) {
            if (sum != grid[i][j + y] + grid[i + 1][j + y] + grid[i + 2][j + y]) {
                return false;
            }
        }

        if (sum != grid[i][j] + grid[i + 1][j + 1] + grid[i + 2][j + 2]) {
            return false;
        }

        if (sum != grid[i + 2][j] + grid[i + 1][j + 1] + grid[i][j + 2]) {
            return false;
        }

        return true;
    }
}