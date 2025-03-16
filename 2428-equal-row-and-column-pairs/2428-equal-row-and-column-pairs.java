class Solution {

    public int equalPairs(int[][] grid) {

        List<String> rows = new ArrayList<>();
        List<String> columns = new ArrayList<>();

        for (var i = 0; i < grid.length; i++) {

            var row = new StringBuilder();
            var column = new StringBuilder();

            for (var j = 0; j < grid[0].length; j++) {
                
                row.append(grid[i][j])
                    .append("-");

                column.append(grid[j][i])
                    .append("-");
            }

            rows.add(row.toString());
            columns.add(column.toString());
        }

        var result = 0;

        for (var row : rows) {
            for (var column : columns) {
                if (row.equals(column)) {
                    ++result;
                }
            }
        }

        return result;
    }
}