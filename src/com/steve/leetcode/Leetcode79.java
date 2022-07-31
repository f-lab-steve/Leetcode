package com.steve.leetcode;

public class Leetcode79 {

    class Solution {

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        public boolean exist(char[][] board, String word) {
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (exist(board, word, visited, row, col, 0)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean exist(char[][] board, String word, boolean[][] visited, int row, int col, int idx) {
            if (word.length() == idx) {
                return true;
            }

            if (!(0 <= row && row < board.length && 0 <= col && col < board[0].length)) {
                return false;
            }

            if (visited[row][col] || board[row][col] != word.charAt(idx)) {
                return false;
            }

            visited[row][col] = true;
            boolean result = false;
            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (exist(board, word, visited, newRow, newCol, idx + 1)) {
                    result = true;
                    break;
                }
            }
            visited[row][col] = false;
            return result;
        }
    }

}
