package com.steve.leetcode;

public class Leetcode76 {

    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }

            int[] tcounts = new int[60];
            for (char c : t.toCharArray()) {
                tcounts[c - 'A']++;
            }

            int start = 0;
            int[] scounts = new int[60];
            int minLen = Integer.MAX_VALUE;
            int minStart = 0;
            int minEnd = 0;
            for (int end = 0; end < s.length(); end++) {
                scounts[s.charAt(end) - 'A']++;

                while (meets(scounts, tcounts)) {
                    if (end - start + 1 < minLen) {
                        minLen = end - start + 1;
                        minStart = start;
                        minEnd = end;
                    }
                    scounts[s.charAt(start++) - 'A']--;
                }
            }

            return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minEnd + 1);
        }

        boolean meets(int[] c1, int[] c2) {
            for (int i = 0; i < 60; i++) {
                if (c1[i] < c2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
