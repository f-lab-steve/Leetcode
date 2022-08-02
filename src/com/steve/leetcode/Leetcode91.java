package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode91 {

    class SolutionTopDown {
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

    class SolutionBottomUp {

        public int numDecodings(String s) {
            if (s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                if (s.charAt(0) == '0') {
                    return 0;
                }
                return 1;
            }

            int[] dp = new int[s.length() + 1];
            dp[0] = 1;

            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                if (num == 0) {
                    continue;
                }
                if (i + 1 <= s.length()) {
                    dp[i + 1] += dp[i];
                }
                if (i + 1 < s.length())  {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    if (num <= 26) {
                        dp[i + 2] += dp[i];
                    }
                }
            }
            return dp[s.length()];
        }

    }

    class SolutionBottomUpSpaceOpt {

        public int numDecodings(String s) {
            if (s.length() == 0) {
                return 0;
            }
            if (s.length() == 1) {
                if (s.charAt(0) == '0') {
                    return 0;
                }
                return 1;
            }

            int dp0 = 1;
            int dp1 = 0;
            int dp2 = 0;

            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - '0';
                if (num != 0) {
                    if (i + 1 <= s.length()) {
                        dp1 += dp0;
                    }
                    if (i + 1 < s.length())  {
                        num = num * 10 + (s.charAt(i + 1) - '0');
                        if (num <= 26) {
                            dp2 += dp0;
                        }
                    }
                }

                dp0 = dp1;
                dp1 = dp2;
                dp2 = 0;
            }
            return dp0;
        }

    }

}
