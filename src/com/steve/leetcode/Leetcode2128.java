package com.steve.leetcode;

public class Leetcode2128 {

    class Solution {
        public boolean removeOnes(int[][] grid) {
            if (grid.length == 0 || grid[0].length == 0) {
                return true;
            }

            for (int col = 0; col < grid[0].length; col++) {
                if (grid[0][col] == 1) {
                    flipCol(grid, col);
                }
            }

            for (int row = 1; row < grid.length; row++) {
                boolean allZeros = true;
                boolean allOnes = true;
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 0) {
                        allOnes = false;
                    }
                    if (grid[row][col] == 1) {
                        allZeros = false;
                    }
                }
                if (!(allZeros || allOnes)) {
                    return false;
                }
            }
            return true;
        }

        void flipCol(int[][] grid, int col) {
            for (int row = 0; row < grid.length; row++) {
                grid[row][col] = grid[row][col] ^ 1;
            }
        }
    }

}
