package com.steve.leetcode;

public class Leetcode130 {

    class Solution {

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void solve(char[][] board) {
            for (int row = 0; row < board.length; row++) {
                dfs(board, row, 0);
                dfs(board, row, board[0].length - 1);
            }
            for (int col = 0; col < board[0].length; col++) {
                dfs(board, 0, col);
                dfs(board, board.length - 1, col);
            }

            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == 'O') {
                        board[row][col] = 'X';
                    }
                    if (board[row][col] == 'Z') {
                        board[row][col] = 'O';
                    }
                }
            }
        }

        void dfs(char[][] board, int row, int col) {
            if (!(0 <= row && row < board.length && 0 <= col && col < board[0].length)) {
                return;
            }

            if (board[row][col] != 'O') {
                return;
            }

            board[row][col] = 'Z';

            for (int[] dir : dirs) {
                dfs(board, row + dir[0], col + dir[1]);
            }
        }

    }

}
