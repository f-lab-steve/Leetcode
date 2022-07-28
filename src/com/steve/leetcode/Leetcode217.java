package com.steve.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode217 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            // sort => n log n, 1
            // set => n, n
            Set<Integer> seen = new HashSet<>();
            for (int num : nums) {
                if (seen.contains(num)) {
                    return true;
                }
                seen.add(num);
            }
            return false;
        }
    }

}
