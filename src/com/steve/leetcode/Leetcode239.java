package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode239 {

    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length < k) {
                return new int[0];
            }

            Deque<Integer> max = new ArrayDeque<>();
            List<Integer> result = new ArrayList<>();
            for (int end = 0; end < nums.length; end++) {
                while (!max.isEmpty() && max.peekLast() < nums[end]) {
                    max.pollLast();
                }
                max.offerLast(nums[end]);

                if (end >= k - 1) {
                    result.add(max.peekFirst());
                }

                if (end - k + 1 >= 0) {
                    if (nums[end - k + 1] == max.peekFirst()) {
                        max.pollFirst();
                    }
                }
            }
            return result.stream().mapToInt(i -> i).toArray();
        }
    }

}
