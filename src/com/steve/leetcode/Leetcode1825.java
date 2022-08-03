package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Leetcode1825 {

    class MKAverage {

        int m;
        int k;
        // num, count
        TreeMap<Integer, Integer> smaller = new TreeMap<>();
        AtomicInteger smallerCount = new AtomicInteger();
        TreeMap<Integer, Integer> larger = new TreeMap<>();
        AtomicInteger largerCount = new AtomicInteger();
        Deque<Integer> window = new ArrayDeque<>();
        TreeMap<Integer, Integer> middle = new TreeMap<>();
        AtomicInteger middleCount = new AtomicInteger();
        int midSum = 0;

        public MKAverage(int m, int k) {
            this.m = m;
            this.k = k;

        }

        public void addElement(int num) {
            window.offer(num);

            if (window.size() > m) {
                int toRemove = window.poll();
                if (toRemove <= smaller.lastKey()) {
                    decrement(smaller, smallerCount, toRemove);
                } else if (larger.firstKey() <= toRemove) {
                    decrement(larger, largerCount, toRemove);
                } else {
                    decrement(middle, middleCount, toRemove);
                    midSum -= toRemove;
                }
            }

            if (smallerCount.get() < k) {
                increment(smaller, smallerCount, num);
            } else if (largerCount.get() < k) {
                increment(larger, largerCount, num);
            } else {
                increment(middle, middleCount, num);
                midSum += num;
            }

            if (!smaller.isEmpty() && !larger.isEmpty()) {
                stabilize(smaller, larger, smallerCount, largerCount);
            }
            if (!smaller.isEmpty() && !middle.isEmpty()) {
                midSum += stabilize(smaller, middle, smallerCount, middleCount);
            }
            if (!middle.isEmpty() && !larger.isEmpty()) {
                midSum -= stabilize(middle, larger, middleCount, largerCount);
            }
        }

        int stabilize(TreeMap<Integer, Integer> smaller, TreeMap<Integer, Integer> larger, AtomicInteger smallerCount, AtomicInteger largerCount) {
            int biggestSmaller = smaller.lastKey();
            int smallestLarger = larger.firstKey();
            if (biggestSmaller > smallestLarger) {
                decrement(smaller, smallerCount, biggestSmaller);
                increment(larger, largerCount, biggestSmaller);
                decrement(larger, largerCount, smallestLarger);
                increment(smaller, smallerCount, smallestLarger);
                return biggestSmaller - smallestLarger;
            }
            return 0;
        }

        void increment(TreeMap<Integer, Integer> container, AtomicInteger counter, int val) {
            container.put(val, container.getOrDefault(val, 0) + 1);
            counter.getAndIncrement();
        }

        void decrement(TreeMap<Integer, Integer> container, AtomicInteger counter, int val) {
            int newCount = container.get(val) - 1;
            counter.getAndDecrement();
            if (newCount == 0) {
                container.remove(val);
            } else {
                container.put(val, newCount);
            }
        }

        public int calculateMKAverage() {
            if (window.size() < m) {
                return -1;
            }
            return midSum / (window.size() - smallerCount.get() - largerCount.get());
        }
    }

}
