package com.steve.leetcode;

public class Leetcode777 {

    class Solution {

        class Count {
            int r;
            int l;

            Count(int r, int l) {
                this.r = r;
                this.l = l;
            }

            boolean isEquals(Count o) {
                return this.r == o.r && this.l == o.l;
            }
        }

        public boolean canTransform(String start, String end) {
            Count startCount = count(start);
            Count endCount = count(end);

            if (!startCount.isEquals(endCount)) {
                return false;
            }

            int si = 0;
            int ei = 0;
            while (si < start.length() && ei < end.length()) {
                while (si < start.length() && start.charAt(si) == 'X') {
                    si++;
                }
                while (ei < end.length() && end.charAt(ei) == 'X') {
                    ei++;
                }

                if (si < start.length() && ei < end.length()) {
                    char sc = start.charAt(si);
                    char ec = end.charAt(ei);
                    if (sc != ec) {
                        return false;
                    }
                    if (sc == 'L' && ei > si) {
                        return false;
                    }
                    if (sc == 'R' && ei < si) {
                        return false;
                    }
                }
                si++;
                ei++;
            }
            return true;
        }

        Count count(String s) {
            int r = 0;
            int l = 0;
            for (char c : s.toCharArray()) {
                if (c == 'R') {
                    r++;
                } else if (c == 'L') {
                    l++;
                }
            }
            return new Count(r, l);
        }
    }
    
}
