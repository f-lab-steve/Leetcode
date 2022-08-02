package com.steve.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode1584 {

    class Solution {
        public int minCostConnectPoints(int[][] points) {
            // calculate distance cost between for every point pair
            // starting from one of the point expand while selecting the minimum distance possible point from the availables
            int[][] distances = new int[points.length][points.length];
            for (int i = 0; i < points.length; i++) {
                for (int j = i + 1; j < points.length; j++) {
                    int[] p1 = points[i];
                    int[] p2 = points[j];
                    distances[j][i] = distances[i][j] = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                }
            }

            Set<Integer> added = new HashSet<>();
            int cost = 0;
            // distance, idx
            PriorityQueue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(i -> i[0]));
            toVisit.add(new int[] {0, 0});
            while (!toVisit.isEmpty()) {
                int[] curr = toVisit.poll();
                int distance = curr[0];
                int idx = curr[1];

                if (added.contains(idx)) {
                    continue;
                }

                added.add(idx);
                cost += distance;

                if (added.size() == points.length) {
                    return cost;
                }

                for (int next = 0; next < points.length; next++) {
                    toVisit.offer(new int[] {distances[idx][next], next});
                }
            }
            return cost;
        }
    }

}
