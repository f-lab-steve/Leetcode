package com.steve.leetcode;

public class Leetcode2331 {

    class Solution {
        public boolean evaluateTree(TreeNode root) {
            // leaf
            // 0 == false
            // 1 == true

            // non - leaf
            // 2 == OR
            // 3 == AND

            // full binary tree
            if (root.val == 0) {
                return false;
            }
            if (root.val == 1) {
                return true;
            }

            boolean left = evaluateTree(root.left);
            boolean right = evaluateTree(root.right);
            if (root.val == 2) {
                return left || right;
            } else {
                return left && right;
            }
        }
    }

}
