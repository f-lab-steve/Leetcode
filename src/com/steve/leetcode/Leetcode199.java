package com.steve.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode199 {

    class Solution {
        public List<Integer> rightSideView(TreeNode root) {
            List<Integer> result = new ArrayList<>();

            rightSide(root, 0, result);

            return result;
        }

        void rightSide(TreeNode root, int depth, List<Integer> result) {
            if (root == null) {
                return;
            }

            if (result.size() <= depth) {
                result.add(root.val);
            }

            rightSide(root.right, depth + 1, result);
            rightSide(root.left, depth + 1, result);
        }
    }

}
