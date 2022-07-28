package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1 {

    class Solution {
        public int[] twoSum(int[] nums, int target) {
            // sort n log n + n
            // set n, n

            Map<Integer, Integer> seen = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (seen.containsKey(target - num)) {
                    return new int[] {i, seen.get(target - num)};
                }
                seen.put(num, i);
            }
            return null;
        }
    }

}
