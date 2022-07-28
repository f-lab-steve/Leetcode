package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode20 {

    class Solution {
        public boolean isValid(String s) {
            Deque<Character> stack = new ArrayDeque<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char end = stack.pop();
                    if (c == ')' && end != '(') {
                        return false;
                    }
                    if (c == '}' && end != '{') {
                        return false;
                    }
                    if (c == ']' && end != '[') {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

}
