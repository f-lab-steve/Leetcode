package com.steve.leetcode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Leetcode2178 {

    class Solution {
        public List<Long> maximumEvenSplit(long finalSum) {
            if (finalSum % 2 == 1) {
                return Collections.emptyList();
            }

            LinkedList<Long> result = new LinkedList<>();
            long curr = 2;
            long sum = 0;
            while (sum + curr <= finalSum) {
                result.addLast(curr);
                sum += curr;
                curr += 2;
            }

            result.addLast(result.removeLast() + finalSum - sum);
            return result;
        }
    }

}
