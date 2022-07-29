package com.steve.leetcode;

public class Leetcode98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean isValidBST(TreeNode root, long minRange, long maxRange) {
            if (root == null) {
                return true;
            }

            if (!(minRange <= root.val && root.val <= maxRange)) {
                return false;
            }

            return isValidBST(root.left, minRange, (long)root.val - 1) && isValidBST(root.right, (long)root.val + 1, maxRange);
        }
    }

}
