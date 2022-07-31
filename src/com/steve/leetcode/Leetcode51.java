package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode51 {

    class Solution {
        public List<List<String>> solveNQueens(int n) {
            char[][] b = new char[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(b[i], '.');
            }

            List<List<String>> r = new ArrayList<>();
            solve(n, 0, b, r);
            return r;
        }

        private void solve(int remain, int r, char[][] b, List<List<String>> result) {
            if (remain == 0) {
                result.add(convert(b));
                return;
            }

            for (int c = 0; c < b.length; c++) {
                if (b[r][c] == 'Q') {
                    continue;
                }

                if (!checkCol(b, r, c)) {
                    continue;
                }
                if (!checkLDiag(b, r, c)) {
                    continue;
                }
                if (!checkRDiag(b, r, c)) {
                    continue;
                }

                b[r][c] = 'Q';
                solve(remain - 1, r + 1, b, result);
                b[r][c] = '.';
            }
        }

        private boolean checkCol(char[][] b, int r, int c) {
            for (int i = 0; i < r; i++) {
                if (b[i][c] == 'Q') {
                    return false;
                }
            }
            return true;
        }

        private boolean checkLDiag(char[][] b, int r, int c) {
            while (r >= 0 && c >= 0) {
                if (b[r][c] == 'Q') {
                    return false;
                }
                r--;
                c--;
            }
            return true;
        }

        private boolean checkRDiag(char[][] b, int r, int c) {
            while (r >= 0 && c < b.length) {
                if (b[r][c] == 'Q') {
                    return false;
                }
                r--;
                c++;
            }
            return true;
        }

        private List<String> convert(char[][] b) {
            List<String> result = new ArrayList<>();
            for (int r = 0; r < b.length; r++) {
                result.add(new String(b[r]));
            }
            return result;
        }
    }

}
