package com.steve.leetcode;

public class Leetcode361 {

    class Solution {
        // time: O(2NM), space: O(2NM)
        public int maxKilledEnemies(char[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return 0;
            }

            int[][][] count = new int[2][grid.length][grid[0].length];

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 'W') {
                        count[0][row][col] = 0;
                        count[1][row][col] = 0;
                    } else {
                        int adder = grid[row][col] == 'E' ? 1 : 0;
                        int left = col > 0 ? count[0][row][col - 1] : 0;
                        count[0][row][col] = left + adder;
                        int top = row > 0 ? count[1][row - 1][col] : 0;
                        count[1][row][col] = top + adder;
                    }
                }
            }

            int max = 0;
            for (int row = grid.length - 1; row >= 0; row--) {
                for (int col = grid[0].length - 1; col >= 0; col--) {
                    if (grid[row][col] == 'W') {
                        continue;
                    }
                    if (col + 1 < grid[0].length && count[0][row][col + 1] > 0) {
                        count[0][row][col] = count[0][row][col + 1];
                    }
                    if (row + 1 < grid.length && count[1][row + 1][col] > 0) {
                        count[1][row][col] = count[1][row + 1][col];
                    }
                    if (grid[row][col] == '0') {
                        max = Math.max(count[0][row][col] + count[1][row][col], max);
                    }
                }
            }
            return max;
        }
    }

}
