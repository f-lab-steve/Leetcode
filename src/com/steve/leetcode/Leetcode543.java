package com.steve.leetcode;

public class Leetcode543 {

    class Solution {

        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            // return the longest path
            // during bottom up calculate inner paths

            longestPath(root);
            return max;
        }

        int longestPath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = longestPath(root.left);
            int right = longestPath(root.right);

            max = Math.max(left + right, max);

            return Math.max(left, right) + 1;
        }
    }

}
