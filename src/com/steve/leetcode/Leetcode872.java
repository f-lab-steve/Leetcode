package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Leetcode872 {

    class Solution {
        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            List<Integer> leaves1 = new ArrayList<>();
            List<Integer> leaves2 = new ArrayList<>();

            getLeaves(root1, leaves1);
            getLeaves(root2, leaves2);

            return Objects.equals(leaves1, leaves2);
        }

        void getLeaves(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            if (root.left == null && root.right == null) {
                result.add(root.val);
                return;
            }

            getLeaves(root.left, result);
            getLeaves(root.right, result);
        }
    }

}
