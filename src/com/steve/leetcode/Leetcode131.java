package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode131 {

    class Solution {
        public List<List<String>> partition(String s) {
            // try to find palindrome cache if possible start pos -> List <String>
            // if palidrome is found, recursively call starting from next pos

            List<List<String>> result = new ArrayList<>();

            partition(s, 0, result, new ArrayList<>());

            return result;
        }

        void partition(String s, int idx, List<List<String>> result, List<String> partitions) {
            if (s.length() == idx) {
                result.add(new ArrayList<>(partitions));
                return;
            }

            for (int i = idx; i < s.length(); i++) {
                if (isPalindrome(s, idx, i)) {
                    partitions.add(s.substring(idx, i + 1));
                    partition(s, i + 1, result, partitions);
                    partitions.remove(partitions.size() - 1);
                }
            }
        }

        boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start) != s.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }

}
