class Solution {

    public int equalPairs(int[][] grid) {

        var n = grid.length;
        var result = 0;

        for (var i = 0; i < n; i++) {

            for (var j = 0; j < n; j++) {

                var isEqual = true;

                for (var x = 0; x < n; x++) {
                    if (grid[i][x] != grid[x][j]) {
                        isEqual = false;
                        break;
                    }
                }

                if (isEqual) {
                    ++result;
                }
            }
        }

        return result;
    }
}