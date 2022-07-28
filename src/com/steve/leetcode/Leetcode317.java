package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode317 {

    class Solution {
        public int shortestDistance(int[][] grid) {
            // brute force
            // collect all the starting points
            // for each starting point perform bfs and add it to a distance matrix, and count matrix
            // loop all the matrix values to find the min value which has count value of all the starting point

            int[][] count = new int[grid.length][grid[0].length];
            int[][] sum = new int[grid.length][grid[0].length];

            int buildings = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        buildings++;
                        if (!bfs(row, col, count, sum, grid, buildings)) {
                            return -1;
                        }
                    }
                }
            }

            int min = Integer.MAX_VALUE;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (count[row][col] == buildings && grid[row][col] == 0) {
                        min = Math.min(min, sum[row][col]);
                    }
                }
            }
            return min == Integer.MAX_VALUE ? -1 : min;
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        boolean bfs(int r, int c, int[][] count, int[][] sum, int[][] grid, int buildings) {
            int distance = 0;
            List<int[]> toVisit = new ArrayList<>();
            boolean[][] added = new boolean[count.length][count[0].length];
            added[r][c] = true;
            toVisit.add(new int[] {r, c});

            int maxCount = 0;
            while (!toVisit.isEmpty()) {
                List<int[]> nextVisit = new ArrayList<>();
                for (int[] curr : toVisit) {
                    int row = curr[0];
                    int col = curr[1];

                    count[row][col]++;
                    maxCount = Math.max(maxCount, count[row][col]);
                    sum[row][col] += distance;

                    for (int[] dir : dirs) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if (0 <= newRow && newRow < count.length && 0 <= newCol && newCol < count[0].length && !added[newRow][newCol] && grid[newRow][newCol] == 0) {
                            added[newRow][newCol] = true;
                            nextVisit.add(new int[] {newRow, newCol});
                        }
                    }
                }

                toVisit = nextVisit;

                distance++;
            }
            return maxCount == buildings;
        }
    }

}
