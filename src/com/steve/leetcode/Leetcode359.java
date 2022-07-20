package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode359 {

    class Logger {

        Map<String, Integer> lastTime = new HashMap<>();

        public Logger() {

        }

        public boolean shouldPrintMessage(int timestamp, String message) {
            Integer prevTime = lastTime.get(message);
            if (prevTime != null && prevTime + 10 > timestamp) {
                return false;
            }

            lastTime.put(message, timestamp);

            return true;
        }
    }

}
