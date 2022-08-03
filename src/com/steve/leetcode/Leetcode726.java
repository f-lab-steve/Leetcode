package com.steve.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode726 {

    class Solution {

        int i = 0;

        public String countOfAtoms(String f) {
            Deque<Map<String, Integer>> stack = new ArrayDeque<>();
            Map<String, Integer> map = new HashMap<>();

            while (i < f.length()) {
                if (f.charAt(i) == '(') {
                    i++;
                    stack.push(map);
                    map = new HashMap<>();
                } else if (f.charAt(i) == ')') {
                    i++;
                    Map<String, Integer> prev = map;
                    map = stack.pop();

                    int num = parseNumber(f);

                    for (String code : prev.keySet()) {
                        map.put(code, map.getOrDefault(code, 0) + prev.get(code) * num);
                    }
                } else {
                    String code = parseCode(f);
                    int num = parseNumber(f);
                    map.put(code, map.getOrDefault(code, 0) + num);
                }
            }

            StringBuilder result = new StringBuilder();
            List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
            Collections.sort(entries, Comparator.comparing(e -> e.getKey()));
            for (Map.Entry<String, Integer> e : entries) {
                result.append(e.getKey());
                if (e.getValue() > 1) {
                    result.append(e.getValue());
                }
            }
            return result.toString();
        }

        int parseNumber(String f) {
            int num = 0;
            while (i < f.length() && Character.isDigit(f.charAt(i))) {
                num = num * 10 + f.charAt(i) - '0';
                i++;
            }
            return Math.max(num, 1);
        }

        String parseCode(String f) {
            if (i >= f.length()) {
                return "";
            }
            StringBuilder code = new StringBuilder();
            if (Character.isAlphabetic(f.charAt(i))) {
                code.append(f.charAt(i));
                i++;
            }
            while (i < f.length() && Character.isAlphabetic(f.charAt(i)) && Character.isLowerCase(f.charAt(i))) {
                code.append(f.charAt(i));
                i++;
            }
            return code.toString();
        }
    }

}
