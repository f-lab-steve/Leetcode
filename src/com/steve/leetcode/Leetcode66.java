package com.steve.leetcode;

public class Leetcode66 {

    class Solution {
        public int[] plusOne(int[] digits) {
            int adder = 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] += adder;
                adder = digits[i] / 10;
                digits[i] %= 10;
            }
            if (adder > 0) {
                int[] newDigits = new int[digits.length + 1];
                for (int i = digits.length - 1; i >= 0; i--) {
                    newDigits[i + 1] = digits[i];
                }
                newDigits[0] = adder;
                digits = newDigits;
            }
            return digits;
        }
    }

}
