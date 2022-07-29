package com.steve.leetcode;

public class Leetcode572 {

    class Solution {

        class HashAndFlag {
            int hash;
            boolean isSubTree;

            HashAndFlag(int hash, boolean isSubTree) {
                this.hash = hash;
                this.isSubTree = isSubTree;
            }
        }

        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            int subRootHash = getHash(subRoot);
            return isSubTree(root, subRoot, subRootHash).isSubTree;
        }

        int getHash(TreeNode root) {
            if (root == null) {
                return 1;
            }
            int hash = getHash(root.left);
            hash = hash * 10007 + getHash(root.right);
            hash = hash * 10007 + root.val + 10001;

            return hash;
        }

        HashAndFlag isSubTree(TreeNode root, TreeNode subRoot, int subRootHash) {
            if (root == null) {
                return new HashAndFlag(1, false);
            }
            HashAndFlag left = isSubTree(root.left, subRoot, subRootHash);
            if (left.isSubTree) return new HashAndFlag(-1, true);
            HashAndFlag right = isSubTree(root.right, subRoot, subRootHash);
            if (right.isSubTree) return new HashAndFlag(-1, true);

            int hash = left.hash;
            hash = hash * 10007 + right.hash;
            hash = hash * 10007 + root.val + 10001;

            boolean isSubTree = false;
            if (hash == subRootHash) {
                isSubTree = equals(root, subRoot);
            }
            return new HashAndFlag(hash, isSubTree);
        }

        boolean equals(TreeNode l, TreeNode r) {
            if (l == null || r == null) {
                if (l == null && r == null) {
                    return true;
                }
                return false;
            }
            return equals(l.left, r.left) && equals(l.right, r.right);
        }
    }

}
