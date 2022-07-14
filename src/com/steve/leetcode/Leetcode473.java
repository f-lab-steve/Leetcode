package com.steve.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode473 {

    class Solution {
        public boolean makesquare(int[] matchsticks) {
            if (matchsticks.length < 4) {
                return false;
            }

            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) {
                return false;
            }

            matchsticks = Arrays.stream(matchsticks)
                    .boxed()
                    .sorted(Comparator.reverseOrder())
                    .mapToInt(Integer::intValue)
                    .toArray();

            int targetSum = sum / 4;
            int[] sums = new int[4];
            return backtrack(sums, matchsticks, 0, targetSum);
        }

        boolean backtrack(int[] sums, int[] sticks, int idx, int target) {
            if (idx == sticks.length) {
                for (int sum : sums) {
                    if (sum != target) {
                        return false;
                    }
                }
                return true;
            }

            for (int i = 0; i < sums.length; i++) {
                if (sums[i] + sticks[idx] > target) {
                    continue;
                }

                sums[i] += sticks[idx];
                if (backtrack(sums, sticks, idx + 1, target)) {
                    return true;
                }
                sums[i] -= sticks[idx];
            }
            return false;
        }

    }

}
