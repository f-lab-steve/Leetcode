package com.steve.leetcode;

public class Leetcode424 {

    class Solution {
        public int characterReplacement(String s, int k) {
            int[] counts = new int[26];
            int maxCount = 0;
            int start = 0;
            int maxLen = 0;
            for (int end = 0; end < s.length(); end++) {
                int curr = s.charAt(end);
                maxCount = Math.max(maxCount, ++counts[curr-'A']);
                if (end - start + 1 - maxCount > k) {
                    counts[s.charAt(start++)-'A']--;
                }
                maxLen = Math.max(end - start + 1, maxLen);
            }
            return maxLen;
        }
    }

}
