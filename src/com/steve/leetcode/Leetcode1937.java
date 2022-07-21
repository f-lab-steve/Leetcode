package com.steve.leetcode;

public class Leetcode1937 {

    class Solution {
        public long maxPoints(int[][] points) {
            // going down the grid per row
            // from above row find the max value that we can add for each column
            // N ^ 3

            // finding the max value from the prev row is a burden
            // depends on the column position, prev rows column position
            // can we restrict the access pattern for prev row?
            // we can perform 2 scan from left to right and right to left
            // the max value we've seen from prev position should be decayed by -1 since we are moving far away from it

            long[][] dp = new long[2][points[0].length];
            for (int col = 0; col < points[0].length; col++) {
                dp[0][col] = points[0][col];
            }

            for (int row = 1; row < points.length; row++) {
                long maxPrev = -123456789;
                // left to right access
                for (int col = 0; col < points[0].length; col++) {
                    maxPrev = Math.max(maxPrev - 1, dp[(row - 1) % 2][col]);
                    dp[row % 2][col] = maxPrev + points[row][col];
                }

                // right to left access
                maxPrev = -123456789;
                for (int col = points[0].length - 1; col >= 0; col--) {
                    maxPrev = Math.max(maxPrev - 1, dp[(row - 1) % 2][col]);
                    dp[row % 2][col] = Math.max(dp[row % 2][col], maxPrev + points[row][col]);
                }
            }

            long result = Integer.MIN_VALUE;
            for (int col = 0; col < points[0].length; col++) {
                result = Math.max(result, dp[(points.length - 1) % 2][col]);
            }
            return result;
        }
    }

}
