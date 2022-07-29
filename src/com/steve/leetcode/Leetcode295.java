package com.steve.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode295 {

    class MedianFinder {

        PriorityQueue<Integer> smallest = new PriorityQueue<>();
        PriorityQueue<Integer> biggest = new PriorityQueue<>(Comparator.reverseOrder());

        public MedianFinder() {

        }

        public void addNum(int num) {
            biggest.offer(num);
            if (!smallest.isEmpty() && biggest.peek() > smallest.peek()) {
                int tmp = smallest.poll();
                smallest.offer(biggest.poll());
                biggest.offer(tmp);
            }
            if (biggest.size() > smallest.size() + 1) {
                int popped = biggest.poll();
                smallest.offer(popped);
            }
        }

        public double findMedian() {
            int num1 = biggest.peek();
            int num2 = biggest.peek();
            if (biggest.size() == smallest.size()) {
                num2 = smallest.peek();
            }

            return (double)(num1 + num2)/2;
        }
    }

}
