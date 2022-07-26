package com.steve.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode315 {

    class Solution {

        class FenwickTree {

            int[] values;

            FenwickTree(int size) {
                values = new int[size + 1];
            }

            void add(int n) {
                n++;
                while (n < values.length) {
                    values[n] += 1;
                    n = n + (n & -n);
                }
            }

            int sum(int n) {
                n++;
                int sum = 0;
                while (n > 0) {
                    sum += values[n];
                    n = n - (n & -n);
                }
                return sum;
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            // brute force
            // for every pos, lookup next and count all the numbers smaller than the current one

            // 1. right -> left + TreeMap, search for keys having lower values and count

            // 2. right -> left + Fenwick tree + bias

            FenwickTree counter = new FenwickTree(20010);
            int bias = 10001;
            int[] result = new int[nums.length];
            for (int i = nums.length - 1; i >= 0; i--) {
                result[i] = counter.sum(nums[i] + bias - 1);
                counter.add(nums[i] + bias);
            }
            return Arrays.stream(result).boxed().collect(Collectors.toList());
        }
    }

}
