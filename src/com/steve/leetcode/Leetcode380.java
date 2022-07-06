package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Leetcode380 {

    class RandomizedSet {

        Map<Integer, Integer> indexMap = new HashMap<>();
        List<Integer> container = new ArrayList<>();
        Random rand = new Random();

        public RandomizedSet() {

        }

        // all methods should work in O(1)

        public boolean insert(int val) {
            if (indexMap.containsKey(val)) {
                return false;
            }

            indexMap.put(val, container.size());
            container.add(val);

            return true;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }

            int valIndex = indexMap.get(val);
            int swapVal = container.get(container.size() - 1);

            container.set(valIndex, swapVal);
            container.remove(container.size() - 1);
            indexMap.put(swapVal, valIndex);
            indexMap.remove(val);

            return true;
        }

        public int getRandom() {
            return container.get(rand.nextInt(container.size()));
        }
    }

}
