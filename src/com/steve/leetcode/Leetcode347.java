package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode347 {

    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> count = new HashMap<>();
            for (int num : nums) {
                count.put(num, count.getOrDefault(num, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(count.entrySet());
            entries.sort(Comparator.comparingInt((Map.Entry<Integer, Integer> e) -> e.getValue()).reversed());
            return entries.stream().mapToInt(e -> e.getKey()).limit(k).toArray();
        }
    }

}
