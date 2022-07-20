package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Leetcode150 {

    class Solution {
        public int evalRPN(String[] tokens) {
            Deque<Integer> stack = new ArrayDeque<>();
            Set<String> operators = new HashSet<>() {{
                add("+");
                add("-");
                add("/");
                add("*");
            }};
            for (String token : tokens) {
                if (operators.contains(token)) {
                    int num2 = stack.pollLast();
                    int num1 = stack.pollLast();
                    int result;
                    if ("+".equals(token)) {
                        result = num1 + num2;
                    } else if ("-".equals(token)) {
                        result = num1 - num2;
                    } else if ("/".equals(token)) {
                        result = num1 / num2;
                    } else {
                        result = num1 * num2;
                    }
                    stack.offerLast(result);
                } else {
                    stack.offerLast(Integer.valueOf(token));
                }
            }
            return stack.poll();
        }
    }

}
