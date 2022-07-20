package com.steve.leetcode;

import java.util.TreeMap;

public class Leetcode2034 {

    class StockPrice {

        TreeMap<Integer, Integer> keySorted = new TreeMap<>(); // timestamp - value
        TreeMap<Integer, Integer> valueSorted = new TreeMap<>(); // value - count

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            // map required
            Integer prevVal = keySorted.put(timestamp, price);
            if (prevVal != null) {
                int newCount = valueSorted.get(prevVal) - 1;
                if (newCount == 0) {
                    valueSorted.remove(prevVal);
                } else {
                    valueSorted.put(prevVal, newCount);
                }
            }
            valueSorted.put(price, valueSorted.getOrDefault(price, 0) + 1);
        }

        public int current() {
            return keySorted.lastEntry().getValue();
        }

        public int maximum() {
            return valueSorted.lastEntry().getKey();
        }

        public int minimum() {
            return valueSorted.firstEntry().getKey();
        }

    }

}
