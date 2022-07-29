package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode90 {

    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(nums);
            subsets(nums, 0, result, new ArrayList<>());

            return result;
        }

        void subsets(int[] nums, int idx, List<List<Integer>> result, List<Integer> set) {
            result.add(new ArrayList<>(set));

            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i - 1]) {
                    continue;
                }
                set.add(nums[i]);
                subsets(nums, i + 1, result, set);
                set.remove(set.size() - 1);
            }
        }
    }

}
