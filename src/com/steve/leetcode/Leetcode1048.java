package com.steve.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode1048 {

    class Solution {
        public int longestStrChain(String[] words) {
            Map<String, Integer> cache = new HashMap<>();
            Set<String> dict = new HashSet<>();
            Collections.addAll(dict, words);

            Arrays.sort(words, Comparator.comparingInt(String::length));

            int max = 0;
            for (String word : words) {
                max = Math.max(max, dfs(word, cache, dict));
            }
            return max;
        }

        int dfs(String word, Map<String, Integer> cache, Set<String> dict) {
            if (cache.containsKey(word)) {
                return cache.get(word);
            }

            int max = 1;
            for (int i = 0; i <= word.length(); i++) {
                String prefix = i == 0 ? "" : word.substring(0, i);
                String suffix = i == word.length() ? "" : word.substring(i);

                for (char c = 'a'; c <= 'z'; c++) {
                    String next = prefix + c + suffix;
                    if (dict.contains(next)) {
                        max = Math.max(max, dfs(next, cache, dict) + 1);
                    }
                }
            }
            cache.put(word, max);
            return max;
        }
    }

}
