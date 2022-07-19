package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode1823 {

    class Solution {
        public int findTheWinner(int n, int k) {
            // queue simulation?
            Deque<Integer> queue = new ArrayDeque<>(n);
            for (int i = 1; i <= n; i++) {
                queue.offer(i);
            }

            while (queue.size() > 1) {
                for (int i = 0; i < k - 1; i++) {
                    Integer item = queue.pollFirst();
                    queue.offerLast(item);
                }
                queue.pollFirst();
            }

            return queue.pollFirst();
        }
    }
    
}
