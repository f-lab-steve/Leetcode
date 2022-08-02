package com.steve.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode416 {

    class SolutionTopDown {
        public boolean canPartition(int[] nums) {
            // first if sum is even
            // for every subset check if it matches with sum/2
            // for given subarray can we make target to be 0?

            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0) {
                return false;
            }

            Map<Integer, Map<Integer, Boolean>> cache = new HashMap<>();
            Arrays.sort(nums);

            return canPartition(nums, 0, sum / 2, cache);
        }

        boolean canPartition(int[] nums, int idx, int target, Map<Integer, Map<Integer, Boolean>> cache) {
            if (target == 0) {
                return true;
            }

            if (idx >= nums.length) {
                return false;
            }

            if (cache.containsKey(idx) && cache.get(idx).containsKey(target)) {
                return cache.get(idx).get(target);
            }

            if (nums[idx] > target) {
                return false;
            }

            boolean result = canPartition(nums, idx + 1, target, cache) || canPartition(nums, idx + 1, target - nums[idx], cache);
            cache.computeIfAbsent(idx, k -> new HashMap<>()).put(target, result);
            return result;
        }
    }

    class SolutionBottomUp {

        public boolean canPartition(int[] nums) {
            int sum = 0;
            for (int num : nums) {
                sum += num;
            }

            if (sum % 2 != 0) {
                return false;
            }

            boolean[] dp = new boolean[sum / 2 + 1];
            dp[0] = true;

            for (int num : nums) {
                for (int i = sum / 2; i >= num; i--) {
                    dp[i] = dp[i] || dp[i - num];
                }
            }
            return dp[sum / 2];
        }

    }

}
