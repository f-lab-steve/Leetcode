package com.steve.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1101 {

    class Solution {
        public int earliestAcq(int[][] logs, int n) {
            if (logs.length < n - 1) {
                return -1;
            }

            Arrays.sort(logs, Comparator.comparingInt(log -> log[0]));

            // check every person is having same group after each log (n <= 100)
            // time: O(logs * n * search time)

            // union-find?
            int[] group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }

            for (int[] log : logs) {
                union(group, log[1], log[2]);

                if (checkAllInSameGroup(group)) {
                    return log[0];
                }
            }
            return -1;
        }

        boolean checkAllInSameGroup(int[] group) {
            int g = find(group, 0);
            for (int i = 1; i < group.length; i++) {
                if (g != find(group, i)) {
                    return false;
                }
            }
            return true;
        }

        int find(int[] group, int i) {
            int curr = i;
            while (group[curr] != curr) {
                curr = group[curr];
            }
            return curr;
        }

        void union(int[] group, int i, int j) {
            int iroot = find(group, i);
            int jroot = find(group, j);

            group[jroot] = iroot;
        }
    }

}
