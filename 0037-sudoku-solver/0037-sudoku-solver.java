class Solution {

    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private static boolean solve(char[][] board, int row, int col) {

        if (row == 9) {
            return true;
        }

        if (col == 9) {
            return solve(board, row + 1, 0);
        }

        if (board[row][col] != '.') {
            return solve(board, row, col + 1);
        }

        for (var i = '1'; i <= '9'; i++) {

            var c = (char) i;

            if (isValidPlacement(board, c, row, col)) {

                board[row][col] = c;

                if (solve(board, row, col + 1)) {
                    return true;
                }

                board[row][col] = '.';
            }
        }

        return false;
    }

    private static boolean isValidPlacement(char[][] board, char placement, int x, int y) {

        for (var i = 0; i < 9; i++) {

            if (board[i][y] == placement) {
                return false;
            }

            if (board[x][i] == placement) {
                return false;
            }
        }

        var v = (x / 3) * 3;
        var h = (y / 3) * 3;

        for (var i = v; i < v + 3; i++) {
            for (var j = h; j < h + 3; j++) {
                if (board[i][j] == placement) {
                    return false;
                }
            }
        }

        return true;
    }
}