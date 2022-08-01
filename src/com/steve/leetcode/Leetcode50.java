package com.steve.leetcode;

public class Leetcode50 {

    class Solution {
        public double myPow(double x, int n) {
            if (n < 0) return 1.0/x * myPow(1.0 / x, -(n+1));
            if (n == 0) return 1.0;
            if (n % 2 == 1) return myPow(x, n - 1) * x;
            double pow = myPow(x, n / 2);
            return pow * pow;
        }
    }

}
