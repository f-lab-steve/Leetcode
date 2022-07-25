package com.steve.leetcode;

public class Leetcode419 {

    class Solution {
        public int countBattleships(char[][] board) {
            int count = 0;
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'X') {
                        count++;
                        // clean right
                        for (int c = col + 1; c < board[0].length && board[row][c] == 'X'; c++) {
                            board[row][c] = '.';
                        }
                        // clean down
                        for (int r = row + 1; r < board.length && board[r][col] == 'X'; r++) {
                            board[r][col] = '.';
                        }
                        board[row][col] = '.';
                    }
                }
            }
            return count;
        }
    }

}
