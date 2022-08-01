package com.steve.leetcode;

public class Leetcode190 {

    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int bit = n & (1 << i);
                if (bit != 0) {
                    result = result | (1 << (31 - i));
                }
            }
            return result;
        }
    }

}
