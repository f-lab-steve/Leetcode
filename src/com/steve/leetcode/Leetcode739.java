package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode739 {

    class Solution {
        public int[] dailyTemperatures(int[] temps) {
            Deque<Integer> higher = new ArrayDeque<>();
            int[] result = new int[temps.length];
            for (int i = 0; i < temps.length; i++) {
                while (!higher.isEmpty() && temps[higher.peek()] < temps[i]) {
                    result[higher.peek()] = i - higher.peek();
                    higher.pop();
                }
                higher.push(i);
            }
            return result;
        }
    }

}
