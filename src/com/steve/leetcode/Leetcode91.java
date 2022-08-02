package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode91 {

    class Solution {
        public int numDecodings(String s) {
            int[] cache = new int[s.length()];
            Arrays.fill(cache, -1);
            return decodeWays(s, 0, cache);
        }

        int decodeWays(String s, int idx, int[] cache) {
            if (s.length() == idx) {
                return 1;
            }
            if (cache[idx] != -1) {
                return cache[idx];
            }

            int num = s.charAt(idx) - '0';
            // preceeding 0s are not valid;
            if (num == 0) {
                return 0;
            }
            int result = decodeWays(s, idx + 1, cache);
            if (idx < s.length() - 1) {
                num = num * 10 + (s.charAt(idx + 1) - '0');
                if (num <= 26) {
                    result += decodeWays(s, idx + 2, cache);
                }
            }
            return cache[idx] = result;
        }
    }

}
