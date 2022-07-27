package com.steve.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode839 {

    class Solution {
        public int numSimilarGroups(String[] strs) {
            // union find
            // + how to detect similarity for group. for all strings check similarity?
            // count distinct groups

            // swap equality?
            // collect xor values while comparing, if xor values.size() != 2 false, if size() == 2 then xor == 0 swappable
            // anagrams -> needs only counting

            int[] groups = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                groups[i] = i;
            }

            for (int i = 0; i < strs.length; i++) {
                for (int j = i + 1; j < strs.length; j++) {
                    if (find(groups, i) == find(groups, j)) {
                        continue;
                    }

                    String w1 = strs[i];
                    String w2 = strs[j];
                    int diff = 0;
                    for (int k = 0; k < w1.length() && diff <= 2; k++) {
                        if (w1.charAt(k) != w2.charAt(k)) {
                            diff++;
                        }
                    }

                    if (diff > 2) {
                        continue;
                    }

                    union(groups, i, j);
                }
            }

            Set<Integer> distinctGroups = new HashSet<>();
            for (int i = 0; i < strs.length; i++) {
                distinctGroups.add(find(groups, i));
            }
            return distinctGroups.size();
        }

        int find(int[] groups, int x) {
            if (groups[x] == x) {
                return x;
            }
            return groups[x] = find(groups, groups[x]);
        }

        void union(int[] groups, int x, int y) {
            int xroot = find(groups, x);
            int yroot = find(groups, y);
            groups[xroot] = yroot;
        }
    }

}
