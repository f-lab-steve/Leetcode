package com.steve.leetcode;

public class Leetcode1055 {

    class Solution {
        public int shortestWay(String source, String target) {
            int word = 0;
            int ti = 0;
            int prevTi = 0;

            while (ti < target.length()) {
                for (int si = 0; si < source.length() && ti < target.length(); si++) {
                    if (source.charAt(si) == target.charAt(ti)) {
                        ti++;
                    }
                }
                word++;

                if (ti == prevTi) {
                    return -1;
                }
                prevTi = ti;
            }
            return word;
        }
    }

}
