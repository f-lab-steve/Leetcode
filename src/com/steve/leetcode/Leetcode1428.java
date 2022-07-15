package com.steve.leetcode;

import java.util.List;

public class Leetcode1428 {

    class Solution {
        // time: O(r + c), space: O(1)
        public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
            List<Integer> dim = binaryMatrix.dimensions();
            int rows = dim.get(0);
            int cols = dim.get(1);

            int leftmost = cols;
            for (int row = 0; row < rows; row++) {
                while (leftmost > 0 && binaryMatrix.get(row, leftmost - 1) == 1) {
                    leftmost--;
                }
            }
            return leftmost == cols ? -1 : leftmost;
        }
    }

}
