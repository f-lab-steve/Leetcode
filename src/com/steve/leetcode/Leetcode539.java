package com.steve.leetcode;

import java.util.List;
import java.util.stream.Collectors;

public class Leetcode539 {

    class Solution {
        public int findMinDifference(List<String> timePoints) {
            List<Integer> timeMinutes = timePoints.stream().map(this::convertToMinutes).sorted().collect(Collectors.toList());
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < timeMinutes.size() - 1; i++) {
                minDiff = Math.min(minDiff, timeMinutes.get(i + 1) - timeMinutes.get(i));
            }
            minDiff = Math.min(minDiff, 24*60 - timeMinutes.get(timeMinutes.size() - 1) + timeMinutes.get(0));
            return minDiff;
        }

        int convertToMinutes(String timeString) {
            return Integer.valueOf(timeString.substring(0, 2)) * 60 + Integer.valueOf(timeString.substring(3));
        }
    }
    
}
