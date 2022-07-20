package com.steve.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Leetcode2158 {

    class Solution {
        public int[] amountPainted(int[][] paints) {
            // TreeMap holding ranges
            // Start range as key, End range as value?
            // Merge if necessary?

            int[] result = new int[paints.length];
            // end range -> start range
            TreeMap<Integer, Integer> works = new TreeMap<>();
            for (int i = 0; i < paints.length; i++) {
                int[] paint = paints[i];
                int newStart = paint[0];
                int newEnd = paint[1];

                int start = newStart;
                int end = newEnd;
                int work = newEnd - newStart;
                while (works.ceilingEntry(start) != null) {
                    Map.Entry<Integer, Integer> prevWork = works.ceilingEntry(start);
                    int overlap = calculateOverlap(start, end, prevWork.getValue(), prevWork.getKey());
                    if (overlap < 0) {
                        break;
                    }
                    works.remove(prevWork.getKey());

                    work -= Math.max(0, overlap);

                    start = Math.min(prevWork.getValue(), start);
                    end = Math.max(prevWork.getKey(), end);
                }
                works.put(end, start);

                result[i] = work;
            }
            return result;
        }

        int calculateOverlap(int s1, int e1, int s2, int e2) {
            return Math.min(e2, e1) - Math.max(s1, s2);
        }
    }

}
