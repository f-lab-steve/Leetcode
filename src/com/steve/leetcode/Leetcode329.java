package com.steve.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode329 {

    class Solution {

        class State {
            int row;
            int col;
            int val;

            State(int row, int col, int val) {
                this.row = row;
                this.col = col;
                this.val = val;
            }

            int getVal() {
                return val;
            }
        }

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public int longestIncreasingPath(int[][] matrix) {
            int[][] maxLen = new int[matrix.length][matrix[0].length];
            PriorityQueue<State> toVisit = new PriorityQueue<>(Comparator.comparing(State::getVal));

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    toVisit.offer(new State(row, col, matrix[row][col]));
                }
            }

            int max = 0;
            while (!toVisit.isEmpty()) {
                State curr = toVisit.poll();
                for (int[] dir : dirs) {
                    int newRow = curr.row + dir[0];
                    int newCol = curr.col + dir[1];

                    if (0 <= newRow && newRow < matrix.length && 0 <= newCol && newCol < matrix[0].length && curr.val < matrix[newRow][newCol]) {
                        maxLen[newRow][newCol] = Math.max(maxLen[newRow][newCol], maxLen[curr.row][curr.col] + 1);
                        max = Math.max(max, maxLen[newRow][newCol]);
                    }
                }
            }
            return max + 1;

        }
    }

}
