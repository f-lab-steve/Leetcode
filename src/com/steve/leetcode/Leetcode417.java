package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode417 {

    class Solution {

        int PACIFIC = 1;
        int ATLANTIC = 2;
        int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public List<List<Integer>> pacificAtlantic(int[][] heights) {
            int[][] mark = new int[heights.length][heights[0].length];

            for (int row = 0; row < heights.length; row++) {
                dfs(heights, mark, row, 0, PACIFIC);
            }
            for (int col = 0; col < heights[0].length; col++) {
                dfs(heights, mark, 0, col, PACIFIC);
            }
            for (int row = 0; row < heights.length; row++) {
                dfs(heights, mark, row, heights[0].length - 1, ATLANTIC);
            }
            for (int col = 0; col < heights[0].length; col++) {
                dfs(heights, mark, heights.length - 1, col, ATLANTIC);
            }

            List<List<Integer>> result = new ArrayList<>();
            for (int row = 0; row < heights.length; row++) {
                for (int col = 0; col < heights[0].length; col++) {
                    if (mark[row][col] == PACIFIC + ATLANTIC) {
                        result.add(Arrays.asList(row, col));
                    }
                }
            }
            return result;
        }

        void dfs(int[][] heights, int[][] mark, int row, int col, int marker) {
            if (mark[row][col] >= marker) {
                return;
            }

            mark[row][col] += marker;

            for (int[] dir : DIRS) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (!(0 <= newRow && newRow < heights.length && 0 <= newCol && newCol < heights[0].length)) {
                    continue;
                }

                if (heights[row][col] <= heights[newRow][newCol]) {
                    dfs(heights, mark, newRow, newCol, marker);
                }
            }
        }
    }

}
