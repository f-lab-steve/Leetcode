package com.steve.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Leetcode981 {

    class TimeMapWithTreeMap {

        Map<String, NavigableMap<Integer, String>> values = new HashMap<>();

        public TimeMap() {

        }

        public void set(String key, String value, int timestamp) {
            values.computeIfAbsent(key, k -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            Map.Entry<Integer, String> entry = values.getOrDefault(key, Collections.emptyNavigableMap()).floorEntry(timestamp);
            if (entry == null) {
                return "";
            }
            return entry.getValue();
        }
    }

}
