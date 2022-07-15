package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.TreeMap;

public class Leetcode1438 {

    class SolutionTreeMap {
        // time: O(N log N), space: O(N)
        public int longestSubarray(int[] nums, int limit) {
            if (nums.length == 0) {
                return 0;
            }

            TreeMap<Integer, Integer> counter = new TreeMap<>();
            int s = 0;
            int e = 0;
            int answer = 0;
            while (e < nums.length) {
                int num = nums[e];
                counter.put(num, counter.getOrDefault(num, 0) + 1);
                while (Math.abs(counter.firstKey() - counter.lastKey()) > limit) {
                    int removeNum = nums[s++];
                    int newCount = counter.get(removeNum) - 1;
                    if (newCount < 1) {
                        counter.remove(removeNum);
                    } else {
                        counter.put(removeNum, newCount);
                    }
                }
                answer = Math.max(e - s + 1, answer);
                e++;
            }
            return answer;
        }
    }

    class SolutionDeque {
        // time: O(N), space: O(N)
        public int longestSubarray(int[] nums, int limit) {
            if (nums.length == 0) {
                return 0;
            }

            int answer = 0;
            Deque<Integer> maxes = new ArrayDeque<>();
            Deque<Integer> mins = new ArrayDeque<>();
            int s = 0;
            int e = 0;
            while (e < nums.length) {
                int end = nums[e];
                while (!maxes.isEmpty() && maxes.peekLast() < end) {
                    maxes.pollLast();
                }
                maxes.addLast(end);
                while (!mins.isEmpty() && mins.peekLast() > end) {
                    mins.pollLast();
                }
                mins.addLast(end);

                while (Math.abs(maxes.peekFirst() - mins.peekFirst()) > limit ) {
                    int start = nums[s++];
                    if (mins.peekFirst() == start) {
                        mins.pollFirst();
                    }
                    if (maxes.peekFirst() == start) {
                        maxes.pollFirst();
                    }
                }

                answer = Math.max(answer, e - s + 1);
                e++;
            }
            return answer;
        }
    }
}
