package com.steve.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Leetcode939 {

    class Solution {

        class Table {
            Map<Integer, Set<Integer>> xy = new HashMap<>();

            void put(int x, int y) {
                xy.computeIfAbsent(x, key -> new HashSet<>()).add(y);
            }

            boolean get(int x, int y) {
                return xy.getOrDefault(x, Collections.emptySet()).contains(y);
            }
        }

        public int minAreaRect(int[][] points) {
            if (points.length < 4) {
                return 0;
            }

            Table table = new Table();
            for (int[] point : points) {
                table.put(point[0], point[1]);
            }

            int minArea = Integer.MAX_VALUE;
            for (int i = 0; i < points.length; i++) {
                int[] p1 = points[i];
                for (int j = i + 1; j < points.length; j++) {
                    int[] p2 = points[j];

                    if (p1[0] == p2[0] || p1[1] == p2[1]) {
                        continue;
                    }

                    if (table.get(p1[0], p2[1]) && table.get(p2[0], p1[1])) {
                        int width = Math.abs(p1[0] - p2[0]);
                        int height = Math.abs(p1[1] - p2[1]);
                        int area = width * height;
                        minArea = Math.min(minArea, area);
                    }
                }
            }
            return minArea == Integer.MAX_VALUE ? 0 : minArea;
        }
    }

}
