package com.steve.leetcode;

public class Leetcode647 {

    class Solution {
        public int countSubstrings(String s) {
            int total = 0;
            for (int i = 0; i < s.length(); i++) {
                total += countPalindromes(s, i, i);
                if (i < s.length() - 1) {
                    total += countPalindromes(s, i, i + 1);
                }
            }
            return total;
        }

        int countPalindromes(String str, int s, int e) {
            int count = 0;
            while (0 <= s && e < str.length() && str.charAt(s) == str.charAt(e)) {
                count++;
                s--;
                e++;
            }
            return count;
        }
    }

}
