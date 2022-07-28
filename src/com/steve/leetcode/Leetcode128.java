package com.steve.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int longest = 0;
            for (int num : nums) {
                if (set.contains(num - 1)) {
                    continue;
                }

                int end = num + 1;
                while (set.contains(end)) {
                    end++;
                }

                longest = Math.max(longest, end - num);
            }
            return longest;
        }
    }

}
