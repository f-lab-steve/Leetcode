package com.steve.leetcode;

public class Leetcode105 {

    class Solution {

        int preIdx = 0;

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            // preorder -> left most is the root
            // inorder -> from a root, can split into left and right subtree

            return buildTree(preorder, inorder, 0, inorder.length - 1);
        }

        TreeNode buildTree(int[] pre, int[] in, int instart, int inend) {
            if (instart > inend) {
                return null;
            }

            int rootVal = pre[preIdx++];

            TreeNode root = new TreeNode(rootVal);


            int inIdx = instart;
            while (inIdx <= inend && in[inIdx] != rootVal) inIdx++;

            root.left = buildTree(pre, in, instart, inIdx - 1);
            root.right = buildTree(pre, in, inIdx + 1, inend);
            return root;
        }
    }

}
