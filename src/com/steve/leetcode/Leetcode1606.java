package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class Leetcode1606 {

    class Solution {
        public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
            PriorityQueue<int[]> nextAvailable = new PriorityQueue<>(Comparator.comparingInt((int[] p) -> p[1]));
            TreeSet<Integer> available = new TreeSet<>();
            for (int i = 0; i < k; i++) {
                available.add(i);
            }
            int[] requests = new int[k];
            int maxRequests = 0;
            for (int i = 0; i < arrival.length; i++) {
                while (!nextAvailable.isEmpty() && nextAvailable.peek()[1] <= arrival[i]) {
                    available.add(nextAvailable.poll()[0]);
                }

                int idx = i % k;

                Integer assigned = available.ceiling(idx);
                if (assigned == null) {
                    assigned = available.ceiling(0);
                }
                if (assigned == null) {
                    continue;
                }

                nextAvailable.offer(new int[] {assigned, arrival[i] + load[i]});
                available.remove(assigned);
                requests[assigned]++;
                maxRequests = Math.max(maxRequests, requests[assigned]);
            }

            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < k; i++) {
                if (maxRequests == requests[i]) {
                    result.add(i);
                }
            }
            return result;
        }
    }

}
