package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode394 {

    class Solution {

        int i = 0;

        public String decodeString(String s) {
            StringBuilder curr = new StringBuilder();
            Deque<StringBuilder> builderStack = new ArrayDeque<>();
            Deque<Integer> multiplierStack = new ArrayDeque<>();

            int num = 0;
            while (i < s.length()) {
                if (s.charAt(i) == '[') {
                    builderStack.push(curr);
                    multiplierStack.push(num);
                    curr = new StringBuilder();
                    i++;
                } else if (s.charAt(i) == ']') {
                    StringBuilder tmp = curr;
                    curr = builderStack.pop();
                    int multiplier = multiplierStack.pop();
                    for (int j = 0; j < multiplier; j++) {
                        curr.append(tmp);
                    }
                    i++;
                } else {
                    while (i < s.length() && Character.isAlphabetic(s.charAt(i))) {
                        curr.append(s.charAt(i));
                        i++;
                    }
                    num = 0;
                    while (i < s.length() && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                }
            }
            return curr.toString();
        }
    }

}
