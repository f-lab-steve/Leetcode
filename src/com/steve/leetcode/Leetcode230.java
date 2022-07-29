package com.steve.leetcode;

import java.util.ArrayDeque;

public class Leetcode230 {

    class SolutionRecursive {

        int number = 0;
        int count;

        public int kthSmallest(TreeNode root, int k) {
            count = k;
            inorder(root);
            return number;
        }

        void inorder(TreeNode root) {
            if (root == null) {
                return;
            }

            if (count < 0) {
                return;
            }

            inorder(root.left);

            count--;
            if (count == 0) {
                number = root.val;
                return;
            }

            inorder(root.right);
        }
    }

    class SolutionIterative {
        public int kthSmallest(TreeNode root, int k) {
            Deque<TreeNode> stack = new ArrayDeque<>();
            pushLefts(stack, root);

            int count = 0;
            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                count++;
                if (count == k) {
                    return curr.val;
                }
                pushLefts(stack, curr.right);
            }
            return -1;
        }

        void pushLefts(Deque<TreeNode> stack, TreeNode root) {
            TreeNode curr = root;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
    }

}
