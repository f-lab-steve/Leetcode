package com.steve.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Leetcode489 {

    class Solution {

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        class Table {
            Map<Integer, Map<Integer, Integer>> values = new HashMap<>();

            void put(int row, int col, int val) {
                values.computeIfAbsent(row, k -> new HashMap<>()).put(col, val);
            }

            Integer get(int row, int col) {
                return values.getOrDefault(row, Collections.emptyMap()).get(col);
            }
        }

        public void cleanRoom(Robot robot) {
            Table state = new Table();

            dfs(robot, state, 0, 0, 0);
        }

        void dfs(Robot robot, Table state, int x, int y, int currDir) {
            if (state.get(x, y) != null) {
                return;
            }

            state.put(x, y, 1);

            robot.clean();

            for (int i = 1; i <= 4; i++) {
                robot.turnRight();
                int nextDir = (currDir + i) % 4;
                if (robot.move()) {
                    dfs(robot, state, x + dirs[nextDir][0], y + dirs[nextDir][1], nextDir);
                    robot.turnRight();
                    robot.turnRight();
                    robot.move();
                    robot.turnRight();
                    robot.turnRight();
                }
            }
        }
    }

}
