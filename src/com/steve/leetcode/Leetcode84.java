package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode84 {

    class Solution {
        public int largestRectangleArea(int[] heights) {
            int[] lessLeft = new int[heights.length];
            int[] lessRight = new int[heights.length];

            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < heights.length; i++) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int prev = stack.pop();
                    lessRight[prev] = i;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                lessRight[stack.pop()] = heights.length;
            }

            for (int i = heights.length - 1; i >= 0; i--) {
                while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                    int prev = stack.pop();
                    lessLeft[prev] = i;
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                lessLeft[stack.pop()] = -1;
            }

            int maxArea = 0;
            for (int i = 0; i < heights.length; i++) {
                int width = lessRight[i] - lessLeft[i] - 1;
                int area = width * heights[i];
                maxArea = Math.max(area, maxArea);
            }
            return maxArea;
        }
    }

}
