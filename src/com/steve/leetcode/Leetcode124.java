package com.steve.leetcode;

public class Leetcode124 {

    class Solution {

        int max = 0;

        public int maxPathSum(TreeNode root) {
            // bottom up, build path sum
            // while at each root connect sub path sum
            maxPath(root);
            return max;
        }

        int maxPath(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int left = maxPath(root.left);
            int right = maxPath(root.right);
            max = Math.max(max, left + right + root.val);

            return Math.max(left, right) + root.val;
        }
    }

}
