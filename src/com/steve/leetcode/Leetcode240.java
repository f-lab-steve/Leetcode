package com.steve.leetcode;

public class Leetcode240 {

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            // each row are sorted left -> right
            // columns are sorted top -> bottom

            // curr val < target == either down or right
            // curr val >= target == either up or left

            // starting from upper right => no up no right
            // curr val >= target -> go left
            // curr val < target -> go down

            if (matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int r = 0;
            int c = matrix[0].length - 1;

            while (r < matrix.length && c >= 0) {
                if (matrix[r][c] == target) {
                    return true;
                }

                if (matrix[r][c] < target) {
                    r++;
                } else {
                    c--;
                }
            }
            return false;
        }
    }

}
