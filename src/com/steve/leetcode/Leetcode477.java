package com.steve.leetcode;

public class Leetcode477 {

    class Solution {
        public int totalHammingDistance(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int ones = 0;
                for (int num : nums) {
                    ones += (num >> i) & 1;
                }
                int zeros = nums.length - ones;
                result += ones * zeros;
            }
            return result;
        }
    }

}
