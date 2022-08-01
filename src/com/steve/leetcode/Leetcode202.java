package com.steve.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Leetcode202 {

    class Solution {
        public boolean isHappy(int n) {
            // positive number -> sum of digit^2
            // until 1
            // if ends with 1 then happy number
            // cycle detection

            Set<Integer> seen = new HashSet<>();
            while (n != 1) {
                if (seen.contains(n)) {
                    return false;
                }

                seen.add(n);
                int sum = 0;
                while (n > 0) {
                    int digit = n % 10;
                    sum += digit * digit;
                    n /= 10;
                }
                n = sum;
            }
            return true;
        }
    }

}
