package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode49 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> groups = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                groups.computeIfAbsent(new String(chars), k -> new ArrayList<>()).add(str);
            }
            return new ArrayList<>(groups.values());
        }
    }

}
