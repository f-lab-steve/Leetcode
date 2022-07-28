package com.steve.leetcode;

public class Leetcode42 {

    class Solution {
        public int trap(int[] height) {
            int filled = 0;
            int maxLeft = 0;
            int maxRight = 0;

            int l = 0;
            int r = height.length - 1;

            while (l < r) {
                int lh = height[l];
                int rh = height[r];
                int minHeight = Math.min(maxLeft, maxRight);
                if (lh < rh) {
                    filled += Math.max(0, minHeight - lh);
                    l++;
                } else {
                    filled += Math.max(0, minHeight - rh);
                    r--;
                }
                maxLeft = Math.max(maxLeft, lh);
                maxRight = Math.max(maxRight, rh);
            }
            return filled;
        }
    }

}
