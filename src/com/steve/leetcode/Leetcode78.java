package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode78 {

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            subsets(nums, 0, result, new ArrayList<>());

            return result;
        }

        void subsets(int[] nums, int idx, List<List<Integer>> result, List<Integer> set) {
            if (nums.length == idx) {
                result.add(new ArrayList(set));
                return;
            }

            subsets(nums, idx + 1, result, set);
            set.add(nums[idx]);
            subsets(nums, idx + 1, result, set);
            set.remove(set.size() - 1);
        }
    }

}
