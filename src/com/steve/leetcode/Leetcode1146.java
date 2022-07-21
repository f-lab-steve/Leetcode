package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode1146 {

    class SnapshotArray {

        List<Map<Integer, Integer>> snapshots = new ArrayList<>();

        public SnapshotArray(int length) {
            snapshots.add(new HashMap<>());
        }

        public void set(int index, int val) {
            snapshots.get(snapshots.size() - 1).put(index, val);
        }

        public int snap() {
            snapshots.add(new HashMap<>());
            return snapshots.size() - 2;
        }

        public int get(int index, int snap_id) {
            for (int snap = snap_id; snap >= 0; snap--) {
                Integer value = snapshots.get(snap).get(index);
                if (value != null) {
                    return value;
                }
            }
            return 0;
        }
    }

}
