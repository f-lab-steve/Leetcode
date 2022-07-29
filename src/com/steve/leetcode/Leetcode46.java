package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode46 {

    class Solution {
        public List<List<Integer>> permute(int[] nums) {
            boolean[] visited = new boolean[nums.length];
            List<List<Integer>> result = new ArrayList<>();
            permutation(nums, visited, result, new ArrayList<>());
            return result;
        }

        void permutation(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list) {
            if (list.size() == nums.length) {
                result.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    list.add(nums[i]);
                    permutation(nums, visited, result, list);
                    list.remove(list.size() - 1);
                    visited[i] = false;

                }
            }
        }
    }

}
