package com.steve.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode2135 {

    class Solution {
        public int wordCount(String[] startWords, String[] targetWords) {
            Set<Integer> starts = new HashSet<>();
            for (String startWord : startWords) {
                starts.add(convert(startWord));
            }

            int result = 0;
            for (String targetWord : targetWords) {
                int converted = convert(targetWord);
                for (char c : targetWord.toCharArray()) {
                    int transformed = converted ^ (1 << c - 'a');
                    if (starts.contains(transformed)) {
                        result++;
                        break;
                    }
                }
            }
            return result;
        }

        int convert(String word) {
            int result = 0;
            for (char c : word.toCharArray()) {
                result += 1 << (c - 'a');
            }
            return result;
        }
    }

}
