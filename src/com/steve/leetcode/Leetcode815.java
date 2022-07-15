package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Leetcode815 {

    class Solution {
        // time: O(route * len(route)), space: O(len(route))
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }

            Map<Integer, List<Integer>> busToStations = new HashMap<>();
            Map<Integer, Set<Integer>> stationToBuses = new HashMap<>();
            Set<Integer> visitedBus = new HashSet<>();
            for (int bus = 0; bus < routes.length; bus++) {
                int[] route = routes[bus];
                List<Integer> stations = new ArrayList<>(route.length);
                for (int station : route) {
                    stations.add(station);
                    Set<Integer> buses = stationToBuses.computeIfAbsent(station, k -> new HashSet<>());
                    buses.add(bus);
                }
                busToStations.put(bus, stations);
            }

            if (stationToBuses.get(source) == null) {
                return -1;
            }

            List<Integer> toVisit = new ArrayList<>(stationToBuses.get(source));
            int transfers = 1;
            while (!toVisit.isEmpty()) {
                List<Integer> nextVisit = new ArrayList<>();
                for (int bus : toVisit) {
                    if (visitedBus.contains(bus)) {
                        continue;
                    }

                    visitedBus.add(bus);

                    for (int station : busToStations.get(bus)) {
                        if (station == target) {
                            return transfers;
                        }

                        if (stationToBuses.containsKey(station)) {
                            for (int nextBus : stationToBuses.get(station)) {
                                if (!visitedBus.contains(nextBus)) {
                                    nextVisit.add(nextBus);
                                }
                            }
                        }
                    }
                }
                transfers++;
                toVisit = nextVisit;
            }

            return -1;
        }
    }

}
