package com.steve.leetcode;

public class Leetcode36 {

    class Solution {
        public boolean isValidSudoku(char[][] board) {
            int[][] rows = new int[9][9];
            int[][] cols = new int[9][9];
            int[][][] cube = new int[3][3][9];

            for (int row = 0; row < 9; row++) {
                for (int col = 0; col < 9; col++) {
                    if (board[row][col] == '.') {
                        continue;
                    }

                    int num = board[row][col] - '0' - 1;
                    if (rows[row][num]++ > 0) {
                        return false;
                    }
                    if (cols[col][num]++ > 0) {
                        return false;
                    }
                    if (cube[row/3][col/3][num]++ > 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

}
