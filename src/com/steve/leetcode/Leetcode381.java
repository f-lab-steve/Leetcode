package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Leetcode381 {

    class RandomizedCollection {

        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        List<Integer> container = new ArrayList<>();
        Random rand = new Random();

        public RandomizedCollection() {

        }

        public boolean insert(int val) {
            boolean returnVal = !indexMap.containsKey(val);

            Set<Integer> indexes = indexMap.computeIfAbsent(val, key -> new HashSet<>());
            indexes.add(container.size());
            container.add(val);

            return returnVal;
        }

        public boolean remove(int val) {
            if (!indexMap.containsKey(val)) {
                return false;
            }

            Set<Integer> valIndexes = indexMap.get(val);
            int valIndex = valIndexes.iterator().next();
            int swapVal = container.get(container.size() - 1);
            Set<Integer> swapValIndexes = indexMap.get(swapVal);
            container.set(valIndex, swapVal);
            valIndexes.remove(valIndex);
            swapValIndexes.add(valIndex);
            swapValIndexes.remove(container.size() - 1);
            container.remove(container.size() - 1);

            if (valIndexes.isEmpty()) {
                indexMap.remove(val);
            }

            return true;
        }

        public int getRandom() {
            return container.get(rand.nextInt(container.size()));
        }
    }

}
