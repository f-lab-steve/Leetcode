package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode467 {

    class Solution {
        public int findSubstringInWraproundString(String p) {

            int[] maxLen = new int[26];
            int len = 0;
            char prev = ' ';
            for (char c : p.toCharArray()) {
                if (prev + 1 == c || prev == 'z' && c == 'a') {
                    len++;
                } else {
                    len = 1;
                }
                prev = c;

                maxLen[c - 'a'] = Math.max(maxLen[c - 'a'], len);
            }
            return Arrays.stream(maxLen).sum();
        }
    }

}
