package com.flameshine.nebula.problems.leetcode.top_interview_150.matrix;

import java.util.HashSet;
import java.util.Set;

/**
 * №36 Valid Sudoku
 *
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 *   - Each row must contain the digits 1-9 without repetition.
 *   - Each column must contain the digits 1-9 without repetition.
 *   - Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 *
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class ValidSudoku {

    public static void main(String... args) {

        char[][] board = {
            { '5','3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };

        System.out.println(
            isValidSudoku(board)
        );
    }

    private static boolean isValidSudoku(char[][] board) {

        for (char[] cell : board) {
            Set<Character> seen = new HashSet<>();
            for (var j = 0; j < board.length; j++) {
                var current = cell[j];
                if (current != '.' && !seen.add(current)) {
                    return false;
                }
            }
        }

        for (var i = 0; i < board.length; i++) {
            Set<Character> seen = new HashSet<>();
            for (char[] cell : board) {
                var current = cell[i];
                if (current != '.' && !seen.add(current)) {
                    return false;
                }
            }
        }

        for (var i = 0; i < board.length; i += 3) {
            for (var j = 0; j < board.length; j += 3) {
                Set<Character> seen = new HashSet<>();
                for (var x = 0; x < 3; x++) {
                    for (var y = 0; y < 3; y++) {
                        var current = board[i + x][j + y];
                        if (current != '.' && !seen.add(current)) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}