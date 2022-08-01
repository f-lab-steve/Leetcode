package com.steve.leetcode;

public class Leetcode323 {

    class Solution {
        public int countComponents(int n, int[][] edges) {
            int[] groups = new int[n];
            for (int i = 0; i < n; i++) {
                groups[i] = i;
            }

            for (int[] edge : edges) {
                union(groups, edge[0], edge[1]);
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (groups[i] == i) {
                    count++;
                }
            }
            return count;
        }

        void union(int[] groups, int i, int j) {
            int iroot = find(groups, i);
            int jroot = find(groups, j);
            groups[iroot] = jroot;
        }

        int find(int[] groups, int i) {
            if (groups[i] == i) {
                return i;
            }
            return groups[i] = find(groups, groups[i]);
        }
    }

}
