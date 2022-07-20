package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode2115 {

    class Solution {
        public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
            // recipe result can be used for other recipe
            // graph?
            // supplies are leaf node with no dependency

            // maintain a graph with adjacency list

            Map<String, List<String>> adj = new HashMap<>();
            for (int i = 0; i < recipes.length; i++) {
                List<String> list = adj.computeIfAbsent(recipes[i], k -> new ArrayList<>());
                list.addAll(ingredients.get(i));
            }

            for (String supply : supplies) {
                adj.computeIfAbsent(supply, key -> Collections.emptyList());
            }

            Map<String, Boolean> cache = new HashMap<>();
            List<String> result = new ArrayList<>();

            for (String recipe : recipes) {
                dfs(recipe, adj, cache, result);
            }
            return result;
        }

        boolean dfs(String curr, Map<String, List<String>> adj, Map<String, Boolean> cache, List<String> result) {
            if (cache.containsKey(curr)) {
                return cache.get(curr);
            }

            if (!adj.containsKey(curr)) {
                return false;
            }

            if (adj.get(curr).size() == 0) {
                return true;
            }

            cache.put(curr, false);

            boolean subResult = true;
            for (String next : adj.get(curr)) {
                if (!dfs(next, adj, cache, result)) {
                    subResult = false;
                    break;
                }
            }

            if (subResult) {
                result.add(curr);
            }

            cache.put(curr, subResult);
            return subResult;
        }
    }

}
