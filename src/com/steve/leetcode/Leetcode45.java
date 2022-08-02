package com.steve.leetcode;

import java.util.Arrays;

public class Leetcode45 {

    class Solution {
        public int jump(int[] nums) {
            int[] cache = new int[nums.length];
            Arrays.fill(cache, -1);
            int min = minJumps(nums, 0, cache);
            return min;
        }

        int minJumps(int[] nums, int idx, int[] cache) {
            if (cache[idx] != -1) {
                return cache[idx];
            }
            if (idx == nums.length - 1) {
                return 0;
            }
            int min = 123456789;
            for (int i = 1; i <= nums[idx] && idx + i < nums.length; i++) {
                min = Math.min(min, minJumps(nums, idx + i, cache) + 1);
            }
            return cache[idx] = min;
        }
    }

}
