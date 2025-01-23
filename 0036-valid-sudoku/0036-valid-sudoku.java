class Solution {

    public boolean isValidSudoku(char[][] board) {
        
        var height = board.length;
        var width = board[0].length;
        
        for (var i = 0; i < height; i++) {
            Set<Character> raws = new HashSet<>();
            for (var j = 0; j < width; j++) {
                if (board[i][j] != '.' && !raws.add(board[i][j])) {
                    return false;
                }
            }
        }
        
        for (var i = 0; i < width; i++) {
            Set<Character> columns = new HashSet<>();
            for (var j = 0; j < height; j++) {
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (var i = 0; i < height; i += 3) {
            for (var j = 0; j < width; j += 3) {
                Set<Character> squares = new HashSet<>();
                for (var x = 0; x < 3; x++) {
                    for (var y = 0; y < 3; y++) {
                        var current = board[i + x][j + y];
                        if (current != '.' && !squares.add(current)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}