package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode102 {

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();

            if (root == null) {
                return result;
            }

            List<TreeNode> toVisit = new ArrayList<>();
            toVisit.add(root);

            while (!toVisit.isEmpty()) {
                List<TreeNode> nextVisit = new ArrayList<>();
                List<Integer> values = new ArrayList<>();

                for (TreeNode curr : toVisit) {
                    values.add(curr.val);

                    if (curr.left != null) {
                        nextVisit.add(curr.left);
                    }
                    if (curr.right != null) {
                        nextVisit.add(curr.right);
                    }
                }
                toVisit = nextVisit;
                result.add(values);
            }
            return result;
        }
    }

}
