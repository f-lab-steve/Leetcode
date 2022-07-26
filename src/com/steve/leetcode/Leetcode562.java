package com.steve.leetcode;

public class Leetcode562 {

    class Solution {
        public int longestLine(int[][] mat) {
            if (mat == null || mat.length == 0 || mat[0].length == 0) {
                return 0;
            }

            // 0 horizontal
            // 1 vertical
            // 2 diag
            // 3 anti-diag
            int[][][] dp = new int[4][mat.length][mat[0].length];
            int max = 0;
            for (int row = 0; row < mat.length; row++) {
                for (int col = 0; col < mat[0].length; col++) {
                    if (mat[row][col] == 0) {
                        for (int i = 0; i < 4; i++) {
                            dp[i][row][col] = 0;
                        }
                    } else {
                        // horizontal
                        dp[0][row][col] += 1;
                        if (col != 0) {
                            dp[0][row][col] += dp[0][row][col - 1];
                        }

                        // vertical
                        dp[1][row][col] += 1;
                        if (row != 0) {
                            dp[1][row][col] += dp[1][row - 1][col];
                        }

                        // diag (upper left -> bottom right)
                        dp[2][row][col] += 1;
                        if (row != 0 && col != 0) {
                            dp[2][row][col] += dp[2][row - 1][col - 1];
                        }

                        // anti-diag (bottom left -> upper right)
                        dp[3][row][col] += 1;
                        if (row != 0 && col != mat[0].length - 1) {
                            dp[3][row][col] += dp[3][row - 1][col + 1];
                        }

                        for (int i = 0; i < 4; i++) {
                            max = Math.max(max, dp[i][row][col]);
                        }
                    }
                }
            }
            return max;
        }
    }
    
}
