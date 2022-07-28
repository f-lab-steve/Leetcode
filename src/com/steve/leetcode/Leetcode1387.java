package com.steve.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode1387 {

    class Solution {

        class Pair {
            int power;
            int index;

            Pair(int power, int index) {
                this.power = power;
                this.index = index;
            }
        }

        public int getKth(int lo, int hi, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.power).thenComparing(p -> p.index).reversed());
            for (int i = lo; i <= hi; i++) {
                pq.offer(new Pair(getPower(i, cache), i));
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            return pq.poll().index;
        }

        int getPower(int i, Map<Integer, Integer> cache) {
            if (i == 1) {
                return 0;
            }

            Integer cached = cache.get(i);
            if (cached != null) {
                return cached;
            }

            int next = i % 2 == 0
                    ? i / 2
                    : 3 * i + 1;
            int power = getPower(next, cache) + 1;
            cache.put(i, power);
            return power;
        }
    }

}
