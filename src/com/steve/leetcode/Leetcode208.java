package com.steve.leetcode;

public class Leetcode208 {

    class Trie {
        class Node {
            Node[] children = new Node[26];
            boolean isEnd;
        }

        Node root = new Node();

        public Trie() {

        }

        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new Node();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean search(String word) {
            Node node = findNode(word);
            return node != null && node.isEnd;
        }

        public boolean startsWith(String prefix) {
            Node node = findNode(prefix);
            return node != null;
        }

        Node findNode(String word) {
            Node curr = root;
            for (int i = 0; i < word.length() && curr != null; i++) {
                char c = word.charAt(i);
                curr = curr.children[c - 'a'];
            }
            return curr;
        }
    }

}
