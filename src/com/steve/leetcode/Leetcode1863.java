package com.steve.leetcode;

public class Leetcode1863 {

    class SolutionRecursive {

        int result = 0;

        public int subsetXORSum(int[] nums) {
            combi(nums, 0, 0);
            return result;
        }

        void combi(int[] nums, int idx, int xor) {
            if (idx >= nums.length) {
                return;
            }

            int newXor = xor ^ nums[idx];
            result += newXor;

            combi(nums, idx + 1, xor);
            combi(nums, idx + 1, newXor);
        }

    }

    class SolutionIterative {

        public int subsetXORSum(int[] nums) {
            int n = nums.length;
            int result = 0;
            for (int i = 0; i < 1 << n; i++) {
                int xor = 0;
                for (int j = 0; j < nums.length; j++) {
                    if ((i & (1 << j)) > 0) {
                        xor ^= nums[j];
                    }
                }
                result += xor;
            }
            return result;
        }

    }

}
