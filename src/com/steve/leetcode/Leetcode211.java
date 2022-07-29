package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode211 {

    class Node {
        boolean end;
        Map<Character, Node> children = new HashMap<>();
    }

    class WordDictionary {


        Node root = new Node();
        /** Initialize your data structure here. */
        public WordDictionary() {

        }

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                Node child = curr.children.computeIfAbsent(c, key -> new Node());
                curr = child;
            }
            curr.end = true;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Node curr, String word, int i) {
            if (i == word.length()) {
                return curr != null && curr.end;
            }

            char c = word.charAt(i);
            char start = c;
            char end = c;
            if (c == '.') {
                start = 'a';
                end = 'z';
            }

            for (char sc = start; sc <= end; sc++) {
                Node child = curr.children.get(sc);
                if (child == null) {
                    continue;
                }

                if (search(child, word, i + 1)) {
                    return true;
                }
            }

            return false;
        }
    }

}
