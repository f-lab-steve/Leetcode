package com.steve.leetcode;

public class Leetcode1861 {

    class Solution {
        // time: O(2*row*col), space = O(row*col)
        public char[][] rotateTheBox(char[][] box) {
            // push
            for (int row = 0; row < box.length; row++) {
                int writeIndex = box[0].length - 1;
                for (int col = box[0].length - 1; col >= 0; col--) {
                    if (box[row][col] == '#') {
                        box[row][writeIndex--] = '#';
                    } else if (box[row][col] == '*') {
                        while (writeIndex > col) {
                            box[row][writeIndex--] = '.';
                        }
                        writeIndex = col - 1;
                    }
                }
                while (writeIndex >= 0) {
                    box[row][writeIndex--] = '.';
                }
            }

            // rotate
            char[][] result = new char[box[0].length][box.length];
            for (int row = 0; row < box.length; row++) {
                for (int col = 0; col < box[0].length; col++) {
                    result[col][box.length - row - 1] = box[row][col];
                }
            }
            return result;
        }
    }

}
