package com.steve.leetcode;

import java.util.PriorityQueue;

public class Leetcode703 {

    class KthLargest {

        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        int k;
        public KthLargest(int k, int[] nums) {
            this.k = k;
            for (int num : nums) {
                update(num);
            }
        }

        public int add(int val) {
            update(val);
            return smallest.peek();
        }

        void update(int val) {
            smallest.offer(val);
            if (smallest.size() > k) {
                smallest.poll();
            }
        }

    }

}
