package com.steve.leetcode;

public class Leetcode1448 {

    class Solution {

        int count = 0;

        public int goodNodes(TreeNode root) {
            findGoodNodes(root, Integer.MIN_VALUE);
            return count;
        }

        void findGoodNodes(TreeNode root, int maxSoFar) {
            if (root == null) {
                return;
            }

            if (maxSoFar <= root.val) {
                count++;
            }

            maxSoFar = Math.max(maxSoFar, root.val);
            findGoodNodes(root.left, maxSoFar);
            findGoodNodes(root.right, maxSoFar);
        }
    }

}
