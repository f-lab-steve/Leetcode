package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Leetcode56 {

    class Solution {
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return intervals;
            }

            Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

            List<int[]> result = new ArrayList<>();
            int[] prev = intervals[0];
            for (int i = 1; i < intervals.length; i++) {
                int[] curr = intervals[i];
                if (prev[1] < curr[0]) {
                    result.add(prev);
                    prev = curr;
                }
                prev[1] = Math.max(curr[1], prev[1]);
            }
            result.add(prev);

            int[][] resultArray = new int[result.size()][];
            for (int i = 0; i < result.size(); i++) {
                resultArray[i] = result.get(i);
            }
            return resultArray;
        }
    }

}
