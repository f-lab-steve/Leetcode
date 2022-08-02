package com.steve.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode139 {

    class SolutionTrie {

        class TrieNode {
            TrieNode[] children = new TrieNode[26];
            boolean isEnd;
        }

        TrieNode root = new TrieNode();

        void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isEnd = true;
        }

        public boolean wordBreak(String s, List<String> wordDict) {
            for (String word : wordDict) {
                addWord(word);
            }

            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 0; i < s.length(); i++) {
                if (!dp[i]) {
                    continue;
                }

                TrieNode curr = root;
                for (int j = i; j < s.length() && curr != null; j++) {
                    curr = curr.children[s.charAt(j) - 'a'];
                    if (curr != null && curr.isEnd) {
                        dp[j + 1] = true;
                    }
                }
            }
            return dp[s.length()];
        }
    }

    class SolutionTopDown {
        public boolean wordBreak(String s, List<String> wordDict) {
            if (s == null || s.length() == 0) {
                return true;
            }
            if (wordDict.size() == 0) {
                return false;
            }

            Map<Integer, Boolean> cache = new HashMap<>();

            return wordBreak(s, new HashSet(wordDict), 0, cache);
        }

        private boolean wordBreak(String str, Set<String> dict, int s, Map<Integer, Boolean> cache) {
            if (s == str.length()) {
                return true;
            }

            if (cache.containsKey(s)) {
                return cache.get(s);
            }

            boolean result = false;
            for (int e = s + 1; e <= str.length(); e++) {
                String word = str.substring(s, e);
                if (!dict.contains(word)) {
                    continue;
                }

                if (wordBreak(str, dict, e, cache)) {
                    result = true;
                    break;
                }
            }

            cache.put(s, result);
            return result;
        }
    }

}
