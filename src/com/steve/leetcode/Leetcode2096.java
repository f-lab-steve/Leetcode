package com.steve.leetcode;

public class Leetcode2096 {

    class Solution {

        String startPath = "";
        String destPath = "";

        public String getDirections(TreeNode root, int startValue, int destValue) {
            findPath(root, startValue, destValue, new StringBuilder());

            int i = 0;
            int max = Math.min(startPath.length(), destPath.length());
            while (i < max && startPath.charAt(i) == destPath.charAt(i)) {
                i++;
            }

            return "U".repeat(startPath.length() - i) + destPath.substring(i);
        }

        void findPath(TreeNode root, int start, int dest, StringBuilder path) {
            if (root == null) {
                return;
            }

            if (root.val == start) {
                startPath = path.toString();
            }
            if (root.val == dest) {
                destPath = path.toString();
            }

            path.append("L");
            findPath(root.left, start, dest, path);
            path.setLength(path.length() - 1);

            path.append("R");
            findPath(root.right, start, dest, path);
            path.setLength(path.length() - 1);
        }

    }

}
