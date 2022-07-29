package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leetcode212 {

    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        public List<String> findWords(char[][] board, String[] words) {
            if (board.length == 0 || board[0].length == 0) {
                return Collections.emptyList();
            }

            Trie trie = new Trie();
            boolean[][] visited = new boolean[board.length][board[0].length];
            for (String word : words) {
                trie.add(word);
            }

            Set<String> result = new HashSet<>();
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    search(board, row, col, visited, trie.root, result);
                }
            }
            return new ArrayList<>(result);
        }

        void search(char[][] board, int row, int col, boolean[][] visited, TrieNode node, Set<String> result) {

            if (visited[row][col]) {
                return;
            }

            char currChar = board[row][col];
            TrieNode currNode = node.children[currChar - 'a'];
            if (currNode == null) {
                return;
            }

            visited[row][col] = true;

            if (currNode.word != null) {
                result.add(currNode.word);
            }

            for (int[] dir : dirs) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (0 <= newRow && newRow < board.length && 0 <= newCol && newCol < board[0].length) {
                    search(board, newRow, newCol, visited, currNode, result);
                }
            }

            visited[row][col] = false;
        }

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            char val;
            String word;

            TrieNode(char val) {
                this.val = val;
            }
        }

        class Trie {
            TrieNode root;

            Trie() {
                root = new TrieNode(' ');
            }

            void add(String word) {
                TrieNode curr = root;
                for (char c : word.toCharArray()) {
                    if (curr.children[c - 'a'] == null) {
                        curr.children[c - 'a'] = new TrieNode(c);
                    }
                    curr = curr.children[c - 'a'];
                }
                curr.word = word;
            }

            TrieNode getNode(String word) {
                TrieNode curr = root;
                for (int i = 0; i < word.length() && curr != null; i++) {
                    char c = word.charAt(i);
                    curr = curr.children[c - 'a'];
                }
                return curr;
            }
        }
    }

}
