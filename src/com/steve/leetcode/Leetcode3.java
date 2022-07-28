package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode3 {

    class Solution {
        public int lengthOfLongestSubstring(String str) {
            Map<Character, Integer> count = new HashMap<>();
            int s = 0;
            int maxLen = 0;
            for (int e = 0; e < str.length(); e++) {
                char curr = str.charAt(e);
                count.put(curr, count.getOrDefault(curr, 0) + 1);

                while (count.get(curr) > 1) {
                    char prev = str.charAt(s++);
                    count.put(prev, count.get(prev) - 1);
                }

                maxLen = Math.max(maxLen, e - s + 1);
            }
            return maxLen;
        }
    }

}
