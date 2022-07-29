package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode39 {

    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();

            Arrays.sort(candidates);
            combSum(candidates, 0, target, result, new ArrayList<>());

            return result;
        }

        void combSum(int[] nums, int idx, int target, List<List<Integer>> result, List<Integer> set) {
            if (target == 0) {
                result.add(new ArrayList<>(set));
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }

                set.add(nums[i]);
                combSum(nums, i, target-nums[i], result, set);
                set.remove(set.size() - 1);
            }
        }
    }

}
