package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode464 {

    class Solution {
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            boolean[] used = new boolean[maxChoosableInteger + 1];
            Map<Integer, Boolean> cache = new HashMap<>();

            int sum = (maxChoosableInteger+1)*maxChoosableInteger/2;
            if (sum < desiredTotal) {
                return false;
            }
            if (desiredTotal <= 0) {
                return true;
            }

            return canWin(used, desiredTotal, cache);
        }

        boolean canWin(boolean[] used, int desiredTotal, Map<Integer, Boolean> cache) {
            int cacheKey = getCacheKey(used);
            if (cache.containsKey(cacheKey)) {
                return cache.get(cacheKey);
            }

            if (desiredTotal <= 0) {
                return false;
            }

            boolean result = false;
            for (int i = 1; i < used.length; i++) {
                if (used[i]) {
                    continue;
                }

                used[i] = true;
                if (!canWin(used, desiredTotal - i, cache)) {
                    result = true;
                }
                used[i] = false;

                if (result) {
                    break;
                }
            }

            cache.put(cacheKey, result);
            return result;
        }

        int getCacheKey(boolean[] used) {
            int key = 0;
            for (int i = 1; i < used.length; i++) {
                int val = used[i] ? 1 : 0;
                key <<= 1;
                key |= val;
            }
            return key;
        }
    }

}
