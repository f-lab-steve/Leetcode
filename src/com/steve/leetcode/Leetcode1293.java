package com.steve.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode1293 {

    class Solution {

        class State {
            int x;
            int y;
            int used;

            String key = null;

            State(int x, int y, int used) {
                this.x = x;
                this.y = y;
                this.used = used;
            }

            String getKey() {
                if (key == null) {
                    key = String.format("%d %d", x, y);
                }
                return key;
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int shortestPath(int[][] grid, int k) {
            // BFS
            // state: steps, how many blocks were killed
            // visited: coordinates -> block kill count map

            List<State> toVisit = new LinkedList<>() {{
                add(new State(0, 0, 0));
            }};
            Map<String, Integer> visited = new HashMap<>();
            int steps = 0;
            int maxX = grid.length;
            int maxY = grid[0].length;
            int targetX = maxX - 1;
            int targetY = maxY - 1;

            while (!toVisit.isEmpty()) {
                List<State> nextVisit = new LinkedList<>();

                for (State curr : toVisit) {
                    Integer count = visited.get(curr.getKey());
                    if (count != null && curr.used >= count) {
                        continue;
                    }

                    visited.put(curr.getKey(), curr.used);

                    if (curr.x == targetX && curr.y == targetY) {
                        return steps;
                    }

                    for (int[] dir : dirs) {
                        int newX = curr.x + dir[0];
                        int newY = curr.y + dir[1];

                        if (0 <= newX && newX < maxX && 0 <= newY && newY < maxY) {
                            int newUsed = curr.used + grid[newX][newY];
                            State next = new State(newX, newY, newUsed);
                            if (next.used > k) {
                                continue;
                            }

                            Integer minUsed = visited.get(next.getKey());
                            if (minUsed != null && next.used >= minUsed) {
                                continue;
                            }

                            nextVisit.add(next);
                        }
                    }

                    toVisit = nextVisit;
                }

                steps++;
            }

            return -1;
        }
    }

}
