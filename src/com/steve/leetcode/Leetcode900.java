package com.steve.leetcode;

public class Leetcode900 {

    class RLEIterator {

        int[] values;

        // current position in current value
        int position = 0;
        int idx = 0;


        public RLEIterator(int[] encoding) {
            // i % 2 == 0 -> repeats
            // i % 2 == 1 -> number
            this.values = encoding;
        }

        public int next(int n) {
            while (idx < values.length && values[idx] < position + n) {
                n -= values[idx] - position;
                position = 0;
                idx += 2;
            }
            position += n;
            if (idx >= values.length) {
                return -1;
            }
            return values[idx + 1];
        }
    }

}
