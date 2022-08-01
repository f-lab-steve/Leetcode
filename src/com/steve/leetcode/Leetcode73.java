package com.steve.leetcode;

public class Leetcode73 {

    class SolutionInMemory {
        public void setZeroes(int[][] matrix) {
            boolean colZero = false;
            boolean rowZero = false;

            for (int row = 0; row < matrix.length; row++) {
                for (int col = 0; col < matrix[0].length; col++) {
                    if (matrix[row][col] == 0) {
                        matrix[row][0] = 0;
                        matrix[0][col] = 0;

                        if (row == 0) {
                            rowZero = true;
                        }
                        if (col == 0) {
                            colZero = true;
                        }
                    }
                }
            }

            for (int row = 1; row < matrix.length; row++) {
                if (matrix[row][0] == 0) {
                    for (int col = 1; col < matrix[0].length; col++) {
                        matrix[row][col] = 0;
                    }
                }
            }
            for (int col = 1; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0) {
                    for (int row = 1; row < matrix.length; row++) {
                        matrix[row][col] = 0;
                    }
                }
            }
            if (colZero) {
                for (int row = 0; row < matrix.length; row++) {
                    matrix[row][0] = 0;
                }
            }
            if (rowZero) {
                for (int col = 0; col < matrix[0].length; col++) {
                    matrix[0][col] = 0;
                }
            }
        }
    }

    class SolutionAdditionalMemory {
        public void setZeroes(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                return;
            }

            int rows = matrix.length;
            int cols = matrix[0].length;

            boolean[] zrows = new boolean[rows];
            boolean[] zcols = new boolean[cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] == 0) {
                        zrows[r] = true;
                        zcols[c] = true;
                    }
                }
            }

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (zrows[r] || zcols[c]) {
                        matrix[r][c] = 0;
                    }
                }
            }
        }
    }

}
