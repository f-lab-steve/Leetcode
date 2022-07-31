package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode994 {

    class Solution {

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int orangesRotting(int[][] grid) {
            List<int[]> toVisit = new ArrayList<>();
            int fresh = 0;
            for (int row = 0; row < grid.length; row++) {
                for (int col = 0; col < grid[0].length; col++) {
                    if (grid[row][col] == 1) {
                        fresh++;
                    }
                    if (grid[row][col] == 2) {
                        toVisit.add(new int[] {row, col});
                    }
                }
            }

            if (fresh == 0) {
                return 0;
            }

            int time = -1;
            while (!toVisit.isEmpty()) {
                List<int[]> nextVisit = new ArrayList<>();
                for (int[] curr : toVisit) {
                    for (int[] dir : dirs) {
                        int newRow = curr[0] + dir[0];
                        int newCol = curr[1] + dir[1];

                        if (0 <= newRow && newRow < grid.length
                                && 0 <= newCol && newCol < grid[0].length
                                && grid[newRow][newCol] == 1) {
                            nextVisit.add(new int[] {newRow, newCol});
                            grid[newRow][newCol] = 2;
                            fresh--;
                        }
                    }
                }

                time++;
                toVisit = nextVisit;
            }

            return fresh == 0 ? time : -1;
        }
    }

}
