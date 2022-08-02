package com.steve.leetcode;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Leetcode743 {

    class Solution {
        public int networkDelayTime(int[][] timesRaw, int n, int k) {
            Map<Integer, Map<Integer, Integer>> times = new HashMap<>();
            for (int[] timeRaw : timesRaw) {
                times.computeIfAbsent(timeRaw[0], key -> new HashMap<>()).put(timeRaw[1], timeRaw[2]);
            }

            // curr idx, total time
            PriorityQueue<int[]> toVisit = new PriorityQueue<>(Comparator.comparingInt(i -> i[1]));
            Set<Integer> added = new HashSet<>();
            toVisit.add(new int[] {k, 0});

            while (!toVisit.isEmpty()) {
                int[] curr = toVisit.poll();
                int currIdx = curr[0];
                int totalTime = curr[1];

                if (added.contains(currIdx)) {
                    continue;
                }
                added.add(currIdx);

                if (added.size() == n) {
                    return totalTime;
                }

                for (Map.Entry<Integer, Integer> e : times.getOrDefault(currIdx, Collections.emptyMap()).entrySet()) {
                    int nextIdx = e.getKey();
                    int nextTime = e.getValue();

                    if (!added.contains(nextIdx)) {
                        toVisit.offer(new int[] {nextIdx, totalTime + nextTime});
                    }
                }

            }
            return -1;
        }
    }

}
