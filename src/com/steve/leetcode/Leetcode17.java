package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode17 {

    class Solution {

        public List<String> letterCombinations(String digits) {
            Map<Character, String> buttonMap = new HashMap<>() {{
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }};

            List<String> result = new ArrayList<>();

            if (digits.length() < 1) {
                return result;
            }

            StringBuilder builder = new StringBuilder();
            combi(digits, 0, builder, buttonMap, result);

            return result;
        }

        void combi(String digits, int idx, StringBuilder builder, Map<Character, String> buttonMap, List<String> result) {
            if (idx >= digits.length()) {
                result.add(builder.toString());
                return;
            }

            for (char c : buttonMap.get(digits.charAt(idx)).toCharArray()) {
                builder.append(c);

                combi(digits, idx + 1, builder, buttonMap, result);

                builder.setLength(builder.length() - 1);
            }
        }

    }

}
