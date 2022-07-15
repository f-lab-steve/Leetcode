package com.steve.leetcode;

public class Leetcode427 {

    class Solution {
        public Node construct(int[][] grid) {
            return buildNode(grid, 0, grid.length - 1, 0, grid.length - 1);
        }


        Node buildNode(int[][] grid, int ys, int ye, int xs, int xe) {
            if (ys == ye) {
                return new Node(grid[ye][xe] == 1 ? true : false, true);
            }

            int ym = ys + (ye - ys) / 2;
            int xm = xs + (xe - xs) / 2;
            Node tl = buildNode(grid, ys, ym, xs, xm);
            Node tr = buildNode(grid, ys, ym, xm + 1, xe);
            Node bl = buildNode(grid, ym + 1, ye, xs, xm);
            Node br = buildNode(grid, ym + 1, ye, xm + 1, xe);


            if (!(tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf)) {
                return new Node(false, false, tl, tr, bl, br);
            }
            if (tl.val && tr.val && bl.val && br.val) {
                return new Node(true, true);
            }
            if (!tl.val && !tr.val && !bl.val && !br.val) {
                return new Node(false, true);
            }
            return new Node(false, false, tl, tr, bl, br);
        }
    }

}
