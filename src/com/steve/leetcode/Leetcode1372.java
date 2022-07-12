package com.steve.leetcode;

public class Leetcode1372 {

    class SolutionBottomUp {

        class Pair {
            int left;
            int right;

            Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        int max = 0;

        public int longestZigZag(TreeNode root) {
            longest(root);

            return max;
        }

        Pair longest(TreeNode root) {
            if (root == null) {
                return new Pair(-1, -1);
            }

            int left = longest(root.left).right + 1;
            int right = longest(root.right).left + 1;

            max = Math.max(max, left);
            max = Math.max(max, right);

            return new Pair(left, right);
        }
    }

    class SolutionTopDown {

        int max = 0;

        public int longestZigZag(TreeNode root) {
            longest(root, 0, 0);
            return max;
        }

        void longest(TreeNode root, int l, int r) {
            if (root == null) {
                return;
            }

            max = Math.max(max, Math.max(l, r));
            longest(root.left, r + 1, 0);
            longest(root.right, 0, l + 1);
        }
    }

}
