package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode22 {

    class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            generate(0, 0, new StringBuilder(), n, result);
            return result;
        }

        void generate(int opens, int closes, StringBuilder s, int n, List<String> result) {
            if (opens == closes && opens == n) {
                result.add(s.toString());
                return;
            }

            if (opens > closes) {
                s.append(")");
                generate(opens, closes + 1, s, n, result);
                s.setLength(s.length() - 1);
            }
            if (opens < n) {
                s.append("(");
                generate(opens + 1, closes, s, n, result);
                s.setLength(s.length() - 1);
            }
        }
    }

}
