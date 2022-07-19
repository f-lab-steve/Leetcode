package com.steve.leetcode;

public class Leetcode2073 {

    class Solution {

        public int timeRequiredToBuy(int[] tickets, int k) {
            int seconds = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (i <= k) {
                    seconds += Math.min(tickets[i], tickets[k]);
                } else {
                    seconds += Math.max(0, Math.min(tickets[i], tickets[k] - 1));
                }
            }
            return seconds;
        }

    }

}
