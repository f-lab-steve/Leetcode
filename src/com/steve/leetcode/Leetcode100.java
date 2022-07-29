package com.steve.leetcode;

public class Leetcode100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) {
                if (p == null && q == null) {
                    return true;
                }
                return false;
            }

            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

}
