package com.steve.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Leetcode2013 {

    class DetectSquares {

        class Table {
            Map<Integer, Map<Integer, Integer>> values = new HashMap<>();

            void put(int r, int c, int v) {
                values.computeIfAbsent(r, k -> new HashMap<>()).put(c, v);
            }

            Integer get(int r, int c) {
                return values.getOrDefault(r, Collections.emptyMap()).get(c);
            }

            Integer getOrDefault(int r, int c, int v) {
                Integer value = get(r, c);
                if (value == null) {
                    return v;
                }
                return value;
            }

            Set<Map.Entry<Integer, Integer>> getColumnEntrySet(int r) {
                return values.getOrDefault(r, Collections.emptyMap()).entrySet();
            }

        }

        Table rowColTable = new Table();
        Table colRowTable = new Table();

        public DetectSquares() {

        }

        public void add(int[] point) {
            int r = point[0];
            int c = point[1];
            rowColTable.put(r, c, rowColTable.getOrDefault(r, c, 0) + 1);
            colRowTable.put(c, r, colRowTable.getOrDefault(c, r, 0) + 1);
        }

        public int count(int[] point) {
            int r1 = point[0];
            int c1 = point[1];

            int result = 0;
            for (Map.Entry<Integer, Integer> sameRow1ColEntry : rowColTable.getColumnEntrySet(r1)) {
                int c2 = sameRow1ColEntry.getKey();
                if (c1 == c2) {
                    continue;
                }

                int distance = Math.abs(c2 - c1);


                result += sameRow1ColEntry.getValue() * rowColTable.getOrDefault(r1 + distance, c1, 0) * rowColTable.getOrDefault(r1 + distance, c2, 0);
                result += sameRow1ColEntry.getValue() * rowColTable.getOrDefault(r1 - distance, c1, 0) * rowColTable.getOrDefault(r1 - distance, c2, 0);

            }
            return result;
        }
    }

}
