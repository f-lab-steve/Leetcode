package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode366 {

    class Solution {

        public List<List<Integer>> findLeaves(TreeNode root) {
            // bottom up, leaf == 0
            // track max height of subtree
            // collect same heights, return in reverse order
            List<List<Integer>> heightNodes = new ArrayList<>();

            traverse(root, heightNodes);

            return heightNodes;
        }

        int traverse(TreeNode root, List<List<Integer>> heightNodes) {
            if (root == null) {
                return -1;
            }

            int height = Math.max(traverse(root.left, heightNodes), traverse(root.right, heightNodes)) + 1;
            if (heightNodes.size() <= height) {
                heightNodes.add(new ArrayList<>());
            }
            List<Integer> nodes = heightNodes.get(height);
            nodes.add(root.val);
            return height;
        }

    }

}
