package com.steve.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

public class Leetcode1046 {

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> heaviest = new PriorityQueue<Integer>(Collections.reverseOrder());
            for (int stone : stones) {
                heaviest.offer(stone);
            }

            while (heaviest.size() > 1) {
                int stone1 = heaviest.poll();
                int stone2 = heaviest.poll();

                if (stone1 != stone2) {
                    int small = Math.min(stone1, stone2);
                    int big = Math.max(stone1, stone2);

                    heaviest.offer(big - small);
                }
            }
            return heaviest.isEmpty() ? 0 : heaviest.poll();
        }
    }

}
