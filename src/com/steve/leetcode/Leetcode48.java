package com.steve.leetcode;

public class Leetcode48 {

    class Solution {
        public void rotate(int[][] matrix) {
            int s = 0;
            int e = matrix.length - 1;

            while (s < e) {
                for (int i = 0; i <= e - s - 1; i++) {
                    int tmp = matrix[s][s + i];
                    matrix[s][s + i] = matrix[e - i][s];
                    matrix[e - i][s] = matrix[e][e - i];
                    matrix[e][e - i] = matrix[s + i][e];
                    matrix[s + i][e] = tmp;
                }
                s++;
                e--;
            }
        }
    }

}
