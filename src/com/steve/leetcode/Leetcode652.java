package com.steve.leetcode;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode652 {

    class Solution {
        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            Map<Integer, List<TreeNode>> duplicateNodes = new HashMap<>();

            bottomUpHash(root, duplicateNodes);

            List<TreeNode> result = new ArrayList<>();
            for (List<TreeNode> duplicates : duplicateNodes.values()) {
                if (hasDuplicates(duplicates)) {
                    result.add(duplicates.get(0));
                }
            }
            return result;
        }

        boolean hasDuplicates(List<TreeNode> list) {
            if (list.size() < 2) {
                return false;
            }
            for (int i = 0; i < list.size(); i++) {
                for (int j = i + 1; j < list.size(); j++) {
                    if (equals(list.get(i), list.get(j))) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean equals(TreeNode root1, TreeNode root2) {
            if (root1 == null || root2 == null) {
                if (root1 == null && root2 == null) {
                    return true;
                }
                return false;
            }

            if (!equals(root1.left, root2.left) || !equals(root1.right, root2.right))  {
                return false;
            }

            return root1.val == root2.val;
        }

        int bottomUpHash(TreeNode root, Map<Integer, List<TreeNode>> duplicates) {
            if (root == null) {
                return 1;
            }

            int hash = bottomUpHash(root.left, duplicates);
            hash = (hash * 10007 + bottomUpHash(root.right, duplicates)) % 1_000_000_007;
            hash = (hash * 10007 + root.val + 400) % 1_000_000_007;

            duplicates.computeIfAbsent(hash, k -> new ArrayList<>()).add(root);

            return hash;
        }
    }

}
