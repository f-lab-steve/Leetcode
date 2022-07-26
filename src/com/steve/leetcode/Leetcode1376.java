package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1376 {

    class Solution {

        class State {
            int id;
            int time;

            State(int id, int time) {
                this.id = id;
                this.time = time;
            }
        }

        public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
            // build a tree and perform bottom up?

            Map<Integer, List<Integer>> reports = new HashMap<>();
            for (int i = 0; i < manager.length; i++) {
                if (i == headID) {
                    continue;
                }
                reports.computeIfAbsent(manager[i], k -> new ArrayList<>()).add(i);
            }
            List<State> toVisit = new ArrayList<>();
            toVisit.add(new State(headID, 0));

            int max = 0;
            while (!toVisit.isEmpty()) {
                List<State> nextVisit = new ArrayList<>();

                for (State curr : toVisit) {
                    max = Math.max(curr.time, max);

                    for (int report : reports.getOrDefault(curr.id, Collections.emptyList())) {
                        nextVisit.add(new State(report, curr.time + informTime[curr.id]));
                    }
                }

                toVisit = nextVisit;
            }
            return max;
        }
    }

}
