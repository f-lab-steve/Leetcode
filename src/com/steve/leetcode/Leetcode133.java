package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Leetcode133 {

    class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }

            Map<Integer, Node> cloned = new HashMap<>();

            return clone(node, cloned);
        }

        Node clone(Node node, Map<Integer, Node> cloned) {
            if (cloned.containsKey(node.val)) {
                return cloned.get(node.val);
            }

            Node n = new Node(node.val);
            cloned.put(node.val, n);

            List<Node> newNeighbors = new ArrayList<>();
            for (Node next : node.neighbors) {
                newNeighbors.add(clone(next, cloned));
            }
            n.neighbors = newNeighbors;

            return n;
        }
    }

}
