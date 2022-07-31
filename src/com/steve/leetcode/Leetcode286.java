package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode286 {

    class Solution {

        int INF = 2147483647;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public void wallsAndGates(int[][] rooms) {
            List<int[]> toVisit = new ArrayList<>();
            for (int row = 0; row < rooms.length; row++) {
                for (int col = 0; col < rooms[0].length; col++) {
                    if (rooms[row][col] == 0) {
                        toVisit.add(new int[] {row, col});
                    }
                }
            }

            while(!toVisit.isEmpty()) {
                List<int[]> nextVisit = new ArrayList<>();

                for (int[] curr : toVisit) {
                    int row = curr[0];
                    int col = curr[1];
                    for (int[] dir : dirs) {
                        int newRow = row + dir[0];
                        int newCol = col + dir[1];

                        if (0 <= newRow && newRow < rooms.length && 0 <= newCol && newCol < rooms[0].length && rooms[newRow][newCol] == INF) {
                            nextVisit.add(new int[] {newRow, newCol});
                            rooms[newRow][newCol] = rooms[row][col] + 1;
                        }
                    }
                }

                toVisit = nextVisit;
            }
        }
    }

}
