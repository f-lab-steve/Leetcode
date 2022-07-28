package com.steve.leetcode;

public class Leetcode121 {

    class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }

            int minSoFar = prices[0];

            int maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                int profit = Math.max(0, prices[i] - minSoFar);
                minSoFar = Math.min(minSoFar, prices[i]);
                maxProfit = Math.max(maxProfit, profit);
            }
            return maxProfit;
        }
    }

}
