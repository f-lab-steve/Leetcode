package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode54 {

    class Solution {

        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int row = 0;
            int col = 0;
            int dir = 0;
            int rs = 0;
            int re = matrix.length - 1;
            int cs = 0;
            int ce = matrix[0].length - 1;

            while (rs <= re && cs <= ce) {
                result.add(matrix[row][col]);
                if (dir == 0 && col == ce) {
                    dir++;
                    rs++;
                } else if (dir == 1 && row == re) {
                    dir++;
                    ce--;
                } else if (dir == 2 && col == cs) {
                    dir++;
                    re--;
                } else if (dir == 3 && row == rs) {
                    dir++;
                    cs++;
                }
                dir = dir % 4;
                row += dirs[dir][0];
                col += dirs[dir][1];
            }
            return result;
        }
    }

}
