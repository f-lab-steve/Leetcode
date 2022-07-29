package com.steve.leetcode;

public class Leetcode110 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            return getHeight(root) != -1;
        }

        // returns the height of a tree, -1 if it is not balanced
        int getHeight(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = getHeight(root.left);
            if (left == -1) return -1;
            int right = getHeight(root.right);
            if (right == -1) return -1;

            if (Math.abs(left - right) > 1) {
                return -1;
            }
            return Math.max(left, right) + 1;
        }
    }

}
