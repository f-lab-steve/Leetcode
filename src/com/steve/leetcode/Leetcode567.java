package com.steve.leetcode;

public class Leetcode567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }

            int[] s1Counts = new int[26];
            int[] s2Counts = new int[26];

            for (char c : s1.toCharArray()) {
                s1Counts[c - 'a']++;
            }

            int start = 0;
            for (int end = 0; end < s2.length(); end++) {
                char curr = s2.charAt(end);
                s2Counts[curr - 'a']++;
                while (s2Counts[curr - 'a'] > s1Counts[curr - 'a']) {
                    s2Counts[s2.charAt(start++) - 'a']--;
                }
                if (equals(s1Counts, s2Counts)) {
                    return true;
                }
            }
            return false;
        }

        boolean equals(int[] c1, int[] c2) {
            for (int i = 0; i < c1.length; i++) {
                if (c1[i] != c2[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
