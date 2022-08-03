package com.steve.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode1631 {

    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int minimumEffortPath(int[][] heights) {
            if (heights.length == 0 || heights[0].length == 0) {
                return 0;
            }

            // row col max_effort
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i[2]));
            pq.offer(new int[] {0, 0, 0});
            int[][] minEffort = new int[heights.length][heights[0].length];
            for (int[] arr : minEffort) {
                Arrays.fill(arr, 123456789);
            }
            minEffort[0][0] = 0;

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int row = curr[0];
                int col = curr[1];
                int effort = curr[2];

                if (row == heights.length - 1 && col == heights[0].length - 1) {
                    return effort;
                }

                for (int[] dir : dirs) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (0 <= newRow && newRow < heights.length && 0 <= newCol && newCol < heights[0].length) {
                        int newEffort = Math.max(effort, Math.abs(heights[row][col] - heights[newRow][newCol]));
                        if (minEffort[newRow][newCol] > newEffort) {
                            minEffort[newRow][newCol] = newEffort;
                            pq.offer(new int[] {newRow, newCol, newEffort});
                        }
                    }
                }
            }
            return minEffort[heights.length - 1][heights[0].length -1];

        }
    }

}
