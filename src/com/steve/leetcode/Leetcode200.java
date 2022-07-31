package com.steve.leetcode;

public class Leetcode200 {

    class Solution {
        public int numIslands(char[][] grid) {
            int count = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == '1') {
                        dfs(grid, row, col);
                        count++;
                    }
                }
            }
            return count;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        void dfs(char[][] grid, int row, int col) {
            grid[row][col] = '0';

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (!(0 <= newRow && newRow < grid.length && 0 <= newCol && newCol < grid[0].length)) {
                    continue;
                }
                if (grid[newRow][newCol] == '0') {
                    continue;
                }

                dfs(grid, newRow, newCol);
            }
        }
    }

}
