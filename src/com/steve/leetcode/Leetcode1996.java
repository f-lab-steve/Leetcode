package com.steve.leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Leetcode1996 {

    class Solution {
        public int numberOfWeakCharacters(int[][] properties) {
            Arrays.sort(properties, Comparator.comparingInt((int[] p) -> p[0]).thenComparing(Comparator.comparingInt((int[] p) -> p[1]).reversed()));

            int result = 0;
            int maxDefense = 0;
            for (int i = properties.length - 1; i >= 0; i--) {
                int[] p = properties[i];
                if (p[1] < maxDefense) {
                    result++;
                }
                maxDefense = Math.max(maxDefense, p[1]);
            }
            return result;
        }
    }

}
