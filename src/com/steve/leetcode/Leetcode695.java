package com.steve.leetcode;

public class Leetcode695 {

    class Solution {
        public int maxAreaOfIsland(int[][] grid) {
            int max = 0;

            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        int area = dfs(grid, row, col);
                        max = Math.max(max, area);
                    }
                }
            }

            return max;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int dfs(int[][] grid, int row, int col) {
            if (!(0 <= row && row < grid.length && 0 <= col && col < grid[0].length)) {
                return 0;
            }
            if (grid[row][col] == 0) {
                return 0;
            }

            grid[row][col] = 0;
            int result = 1;
            for (int[] dir : dirs) {
                result += dfs(grid, row + dir[0], col + dir[1]);
            }
            return result;
        }
    }

}
