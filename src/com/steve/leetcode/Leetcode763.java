package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode763 {

    class Solution {
        public List<Integer> partitionLabels(String s) {
            int[] lastIndexes = new int[26];
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                lastIndexes[c - 'a'] = i;
            }

            int maxIdx = 0;
            int lastIdx = -1;
            List<Integer> sizes = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                maxIdx = Math.max(maxIdx, lastIndexes[c - 'a']);
                if (maxIdx == i) {
                    sizes.add(i - lastIdx);
                    lastIdx = i;
                }
            }
            return sizes;
        }
    }

}
