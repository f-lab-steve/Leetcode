package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode271 {

    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder sb = new StringBuilder();
            for (String str : strs) {
                sb.append(str.length()).append('.').append(str);
            }
            return sb.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            int i = 0;
            List<String> result = new ArrayList<>();
            while (i < s.length()) {
                int length = 0;
                while (s.charAt(i) != '.') {
                    length *= 10;
                    length += s.charAt(i) - '0';
                    i++;
                }
                i++; // skip .

                result.add(s.substring(i, i + length));
                i += length;
            }
            return result;
        }
    }

}
