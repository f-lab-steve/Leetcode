package com.steve.leetcode;

public class Leetcode242 {

    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] scount = count(s);
            int[] tcount = count(t);

            for (int i = 0; i < 26; i++) {
                if (scount[i] != tcount[i]) {
                    return false;
                }
            }
            return true;
        }

        int[] count(String s) {
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }
            return count;
        }
    }

}
