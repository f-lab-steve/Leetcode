package com.steve.leetcode;

public class Leetcode5 {

    class Solution {
        public String longestPalindrome(String s) {
            // for each position expand palindrome
            // expanding = O(N)
            // repeat 2N

            int[] longest = new int[] {1, 0};
            for (int i = 0; i < s.length(); i++) {
                int[] odd = getLongestPalindrome(s, i, i);
                if (length(longest) < length(odd)) {
                    longest = odd;
                }
                if (i < s.length() - 1) {
                    int[] even = getLongestPalindrome(s, i, i + 1);
                    if (length(longest) < length(even)) {
                        longest = even;
                    }
                }
            }
            return s.substring(longest[0], longest[1] + 1);
        }

        int[] getLongestPalindrome(String str, int s, int e) {
            while (0 <= s && e < str.length() && str.charAt(s) == str.charAt(e)) {
                s--;
                e++;
            }
            return new int[] {s + 1, e - 1};
        }

        int length(int[] palindrome) {
            return Math.max(0, palindrome[1] - palindrome[0] + 1);
        }
    }

}
