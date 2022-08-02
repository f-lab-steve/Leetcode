package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode322 {

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            dp[0] = 0;
            for (int coin : coins) {
                for (int i = 1; i <= amount; i++) {
                    dp[i] = 123456789;
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == 123456789 ? -1 : dp[amount];
        }
    }

}
