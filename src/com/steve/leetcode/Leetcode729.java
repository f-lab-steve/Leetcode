package com.steve.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class Leetcode729 {

    class MyCalendar {

        TreeMap<Integer, Integer> bookings = new TreeMap<>();

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> higher = bookings.higherEntry(start);
            if (higher != null && higher.getValue() < end) {
                return false;
            }
            bookings.put(end, start);
            return true;
        }
    }

}
