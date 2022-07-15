package com.steve.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Leetcode692 {

    class Solution {
        public List<String> topKFrequent(String[] words, int k) {
            Map<String, Integer> count = new HashMap<>();
            for (String word : words) {
                count.put(word, count.getOrDefault(word, 0) + 1);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                    Comparator.comparing(Map.Entry<String, Integer>::getValue)
                            .thenComparing(Map.Entry<String, Integer>::getKey, Comparator.reverseOrder())
            );

            for (Map.Entry<String, Integer> entry : count.entrySet()) {
                pq.offer(entry);
                if (pq.size() > k) {
                    pq.poll();
                }
            }

            LinkedList<String> result = new LinkedList<>();
            for (int i = k - 1; i >= 0; i--) {
                result.addFirst(pq.poll().getKey());
            }
            return result;
        }
    }

}
