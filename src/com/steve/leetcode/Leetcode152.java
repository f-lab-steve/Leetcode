package com.steve.leetcode;

public class Leetcode152 {

    class Solution {
        public int maxProduct(int[] nums) {
            if (nums.length == 0) {
                return 0;
            }

            int neg = nums[0];
            int pos = nums[0];
            int max = nums[0];

            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];

                int prevPos = pos;
                pos = Math.max(Math.max(pos * num, neg * num), num);
                neg = Math.min(Math.min(prevPos * num, neg * num), num);

                max = Math.max(max, pos);
            }

            return max;
        }
    }

}
