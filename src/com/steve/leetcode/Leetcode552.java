package com.steve.leetcode;

public class Leetcode552 {

    class Solution {
        public int checkRecord(int n) {
            // absence, late, n
            long[][][] dp = new long[2][3][n + 1];
            dp[0][0][0] = 1;

            for (int i = 1; i <= n; i++) {
                dp[0][0][i] = (dp[0][0][i - 1] + dp[0][1][i - 1] + dp[0][2][i - 1]) % 1_000_000_007;
                dp[0][1][i] = dp[0][0][i - 1];
                dp[0][2][i] = dp[0][1][i - 1];
                dp[1][0][i] = (dp[0][0][i - 1] + dp[0][1][i - 1] + dp[0][2][i - 1] + dp[1][0][i - 1] + dp[1][1][i - 1] + dp[1][2][i - 1]) % 1_000_000_007;
                dp[1][1][i] = dp[1][0][i - 1];
                dp[1][2][i] = dp[1][1][i - 1];
            }

            int result = 0;
            for (int a = 0; a < 2; a++) {
                for (int l = 0; l < 3; l++) {
                    result += dp[a][l][n];
                    result %= 1_000_000_007;
                }
            }
            return result;
        }
    }

}
