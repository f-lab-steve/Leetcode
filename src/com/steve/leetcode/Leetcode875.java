package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode875 {

    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int lo = 1;
            int hi = Arrays.stream(piles).max().getAsInt();

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (eatTime(piles, mid) > h) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        long eatTime(int[] piles, int speed) {
            long hours = 0;
            for (int pile : piles) {
                hours += (int) Math.ceil((double) pile / speed);
            }
            return hours;
        }
    }

}
