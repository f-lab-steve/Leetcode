package com.steve.leetcode;

public class Leetcode261 {

    class Solution {
        public boolean validTree(int n, int[][] edges) {
            // tree means no cycle
            int[] groups = new int[n];
            for (int i = 0; i < n; i++) {
                groups[i] = i;
            }

            for (int[] e : edges) {
                int group1 = find(groups, e[0]);
                int group2 = find(groups, e[1]);

                // cycle detected
                if (group1 == group2) {
                    return false;
                }

                union(groups, e[0], e[1]);
            }

            // need to check all the vertices are in the same group
            int target = find(groups, 0);
            for (int i = 1; i < n; i++) {
                if (find(groups, i) != target) {
                    return false;
                }
            }
            return true;
        }

        int find(int[] groups, int i) {
            if (groups[i] == i) {
                return i;
            }
            return groups[i] = find(groups, groups[i]);
        }

        void union(int[] groups, int i, int j) {
            int iroot = find(groups, i);
            int jroot = find(groups, j);
            groups[iroot] = jroot;
        }

    }

}
