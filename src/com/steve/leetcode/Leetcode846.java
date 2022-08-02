package com.steve.leetcode;

import java.util.TreeMap;

public class Leetcode846 {

    class Solution {
        public boolean isNStraightHand(int[] hand, int groupSize) {
            TreeMap<Integer, Integer> counts = new TreeMap<>();
            for (int card : hand) {
                counts.put(card, counts.getOrDefault(card, 0) + 1);
            }

            while (!counts.isEmpty()) {
                int firstKey = counts.firstKey();
                for (int i = 0; i < groupSize; i++) {
                    int groupKey = firstKey + i;
                    int count = counts.getOrDefault(groupKey, 0);
                    if (count < 1) {
                        return false;
                    }
                    count--;
                    if (count > 0) {
                        counts.put(groupKey, count);
                    } else {
                        counts.remove(groupKey);
                    }
                }
            }
            return true;
        }
    }

}
