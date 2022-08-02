package com.steve.leetcode;

public class Leetcode55 {

    class Solution {
        public boolean canJump(int[] nums) {
            int max = 0;
            for (int i = 0; i < nums.length && i <= max; i++) {
                max = Math.max(max, nums[i] + i);
            }
            return nums.length - 1 <= max;
        }
    }

}
