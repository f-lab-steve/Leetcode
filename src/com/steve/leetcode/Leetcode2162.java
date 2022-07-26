package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode2162 {

    class Solution {
        public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
            // target seconds

            // seconds can be set value between 0~99
            // minutes can be anything
            // the cost function can be either
            // 1. targetSeconds % 60 -> digits + targetSeconds / 60 -> digits
            // 2. if targetSeconds % 60 < 39 && targetSeconds / 60 > 0 -> digits and rest

            int seconds = targetSeconds % 60;
            int minutes = targetSeconds / 60;

            System.out.println(String.format("minutes: %d, seconds: %d", minutes, seconds));

            // 1. normal time digits
            int normalCost = Integer.MAX_VALUE;
            if (minutes < 100) {
                normalCost = calculateCost(startAt, getDigits(minutes, seconds), moveCost, pushCost);
            }

            // 2. over seconds digits
            int overSecondCost = Integer.MAX_VALUE;
            if (seconds <= 39 && minutes > 0) {
                overSecondCost = calculateCost(startAt, getDigits(minutes - 1, seconds + 60), moveCost, pushCost);
            }

            return Math.min(normalCost, overSecondCost);
        }

        List<Integer> getDigits(int minutes, int seconds) {
            List<Integer> digits = new ArrayList<>();
            if (minutes / 10 > 0) {
                digits.add(minutes / 10);
            }
            if (minutes > 0) {
                digits.add(minutes % 10);
            }
            if (seconds / 10 > 0 || minutes > 0) {
                digits.add(seconds / 10);
            }
            if (seconds > 0 || minutes > 0) {
                digits.add(seconds % 10);
            }
            System.out.println(digits);
            return digits;
        }

        int calculateCost(int start, List<Integer> digits, int moveCost, int pushCost) {
            int cost = 0;
            int prev = start;
            for (int digit : digits) {
                if (prev != digit) {
                    cost += moveCost;
                }
                prev = digit;
                cost += pushCost;
            }
            return cost;
        }
    }

}
