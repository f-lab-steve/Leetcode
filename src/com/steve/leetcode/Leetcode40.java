package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode40 {

    class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Arrays.sort(candidates);
            combi(candidates, 0, target, result, new ArrayList<>());
            return result;
        }

        void combi(int[] candidates, int idx, int target, List<List<Integer>> result, List<Integer> set) {
            if (target == 0) {
                result.add(new ArrayList<>(set));
                return;
            }

            for (int i = idx; i < candidates.length; i++) {
                if (i > idx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                if (candidates[i] > target) {
                    break;
                }
                set.add(candidates[i]);
                combi(candidates, i + 1, target - candidates[i], result, set);
                set.remove(set.size() - 1);
            }
        }
    }

}
