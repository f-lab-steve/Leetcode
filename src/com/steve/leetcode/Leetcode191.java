package com.steve.leetcode;

public class Leetcode191 {

    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int ones = 0;
            while (n != 0) {
                n = n & (n - 1);
                ones++;
            }
            return ones;
        }
    }

}
