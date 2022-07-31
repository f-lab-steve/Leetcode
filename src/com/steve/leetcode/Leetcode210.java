package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Leetcode210 {

    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> nexts = new HashMap<>();
            for (int[] pre : prerequisites) {
                nexts.computeIfAbsent(pre[1], k -> new ArrayList<>()).add(pre[0]);
            }

            int[] visited = new int[numCourses];
            LinkedList<Integer> order = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(i, visited, order, nexts)) {
                    return new int[0];
                }
            }

            int[] result = new int[order.size()];
            int i = 0;
            for (int course : order) {
                result[i++] = course;
            }
            return result;
        }

        boolean dfs(int i, int[] visited, LinkedList<Integer> order, Map<Integer, List<Integer>> nexts) {
            if (visited[i] == 1) {
                return false;
            }
            if (visited[i] == 2) {
                return true;
            }

            visited[i] = 1;
            for (int next : nexts.getOrDefault(i, Collections.emptyList())) {
                if (visited[next] != 2) {
                    if (!dfs(next, visited, order, nexts)) {
                        return false;
                    }
                }
            }
            visited[i] = 2;
            order.addFirst(i);
            return true;
        }
    }

}
