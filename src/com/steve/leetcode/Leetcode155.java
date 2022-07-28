package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode155 {

    class MinStack {

        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> min = new ArrayDeque<>();

        public MinStack() {

        }

        public void push(int val) {
            stack.push(val);
            if (min.isEmpty() || min.peek() >= val) {
                min.push(val);
            }
        }

        public void pop() {
            int val = stack.pop();
            if (min.peek() == val) {
                min.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

}
