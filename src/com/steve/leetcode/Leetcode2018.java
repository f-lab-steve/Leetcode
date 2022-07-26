package com.steve.leetcode;

public class Leetcode2018 {

    class Solution {

        public boolean placeWordInCrossword(char[][] board, String word) {
            String forward = word;
            String reverse = new StringBuilder(word).reverse().toString();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (board[row][col] == '#') {
                        continue;
                    }
                    if (row == 0 || board[row - 1][col] == '#') {
                        boolean forwardMatch = true;
                        boolean reverseMatch = true;
                        int r = row;
                        while (r < board.length && board[r][col] != '#') {
                            if (r - row < word.length()) {
                                if (!(board[r][col] == ' ' || board[r][col] == forward.charAt(r - row))) {
                                    forwardMatch = false;
                                }
                                if (!(board[r][col] == ' ' || board[r][col] == reverse.charAt(r - row))) {
                                    reverseMatch = false;
                                }

                            } else {
                                forwardMatch = false;
                                reverseMatch = false;

                            }
                            r++;
                        }
                        if (r - row == word.length() && (forwardMatch || reverseMatch)) {
                            return true;
                        }
                    }
                    if (col == 0 || board[row][col - 1] == '#') {
                        boolean forwardMatch = true;
                        boolean reverseMatch = true;
                        int c = col;
                        while (c < board[0].length && board[row][c] != '#') {
                            if (c - col < word.length()) {
                                if (!(board[row][c] == ' ' || board[row][c] == forward.charAt(c - col))) {
                                    forwardMatch = false;
                                }
                                if (!(board[row][c] == ' ' || board[row][c] == reverse.charAt(c - col))) {
                                    reverseMatch = false;
                                }
                            } else {
                                forwardMatch = false;
                                reverseMatch = false;
                            }
                            c++;
                        }
                        if (c - col == word.length() && (forwardMatch || reverseMatch)) {
                            return true;
                        }
                    }
                }
            }

            return false;
        }
    }

}
