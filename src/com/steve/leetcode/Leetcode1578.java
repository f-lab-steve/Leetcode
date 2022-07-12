package com.steve.leetcode;

public class Leetcode1578 {

    class Solution {
        public int minCost(String colors, int[] neededTime) {
            // greedy
            // whenever there is consecutive balloons sum up the cost and find the max cost
            // sum - max == remove cost
            // sum up all the remove cost

            int sumCost = 0;
            int localSum = 0;
            int localMax = 0;
            for (int i = 0; i < colors.length(); i++) {
                if (i == 0 || colors.charAt(i) != colors.charAt(i - 1)) {
                    sumCost += localSum - localMax;
                    localSum = 0;
                    localMax = 0;
                }
                localSum += neededTime[i];
                localMax = Math.max(localMax, neededTime[i]);
            }
            sumCost += localSum - localMax;

            return sumCost;
        }
    }
}
