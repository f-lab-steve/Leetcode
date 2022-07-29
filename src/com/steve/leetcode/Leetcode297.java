package com.steve.leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class Leetcode297 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder result = new StringBuilder();
            serialize(root, result);
            System.out.println(result);
            return result.toString();
        }

        void serialize(TreeNode root, StringBuilder result) {
            if (root == null) {
                return;
            }

            result.append(root.val);
            result.append('(');
            serialize(root.left, result);
            result.append(',');
            serialize(root.right, result);
            result.append(')');
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            AtomicInteger i = new AtomicInteger();
            return deserialize(data, i);
        }

        TreeNode deserialize(String data, AtomicInteger i) {
            if (i.get() >= data.length()) {
                return null;
            }

            if (data.charAt(i.get()) != '-' && !Character.isDigit(data.charAt(i.get()))) {
                return null;
            }

            int sign = 1;
            if (data.charAt(i.get()) == '-') {
                sign *= -1;
                i.getAndIncrement();
            }

            int val = 0;
            while (Character.isDigit(data.charAt(i.get()))) {
                val *= 10;
                val += data.charAt(i.get()) - '0';
                i.getAndIncrement();
            }
            val *= sign;

            TreeNode root = new TreeNode(val);
            // skip (
            i.getAndIncrement();
            root.left = deserialize(data, i);
            // skip ,
            i.getAndIncrement();
            root.right = deserialize(data, i);
            // skip )
            i.getAndIncrement();

            return root;
        }
    }

}
