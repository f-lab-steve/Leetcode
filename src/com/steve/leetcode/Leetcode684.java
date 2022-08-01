package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode684 {

    class Solution {
        public int[] findRedundantConnection(int[][] edges) {
            int[] result = null;
            Map<Integer, Integer> groups = new HashMap<>();
            for (int[] e : edges) {
                for (int v : e) {
                    if (!groups.containsKey(v)) {
                        groups.put(v, v);
                    }
                }

                int group1 = find(groups, e[0]);
                int group2 = find(groups, e[1]);
                if (group1 == group2) {
                    result = e;
                }

                union(groups, e[0], e[1]);
            }
            return result;
        }

        int find(Map<Integer, Integer> groups, int i) {
            if (groups.get(i) == i) {
                return i;
            }
            int root = find(groups, groups.get(i));
            groups.put(i, root);
            return root;
        }

        void union(Map<Integer, Integer> groups, int i, int j) {
            int iroot = find(groups, i);
            int jroot = find(groups, j);

            groups.put(iroot, jroot);
        }
    }

}
