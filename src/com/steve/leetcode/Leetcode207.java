package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode207 {

    class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> nexts = new HashMap<>();
            // curr -> dependency
            for (int[] pre : prerequisites) {
                nexts.computeIfAbsent(pre[0], k -> new ArrayList<>()).add(pre[1]);
            }

            int[] visited = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                if (visited[i] == 0) {
                    if (!dfs(i, visited, nexts)) {
                        return false;
                    }
                }
            }
            return true;
        }

        boolean dfs(int i, int[] visited, Map<Integer, List<Integer>> nexts) {
            if (visited[i] == 2) {
                return false;
            }

            visited[i] = 2;

            for (int next : nexts.getOrDefault(i, Collections.emptyList())) {
                if (visited[next] == 1) {
                    continue;
                }
                if(!dfs(next, visited, nexts)) {
                    return false;
                }
            }

            visited[i] = 1;

            return true;
        }
    }

}
