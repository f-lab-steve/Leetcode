package com.steve.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode778 {

    class Solution {

        class Point {
            int x;
            int y;
            int height;

            Point(int x, int y, int height) {
                this.x = x;
                this.y = y;
                this.height = height;
            }

            int getHeight() {
                return height;
            }
        }


        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int swimInWater(int[][] grid) {
            PriorityQueue<Point> toVisit = new PriorityQueue<>(Comparator.comparing(Point::getHeight));
            boolean[][] queued = new boolean[grid.length][grid[0].length];
            toVisit.add(new Point(0, 0, grid[0][0]));
            queued[0][0] = true;

            int t = 0;
            while (!toVisit.isEmpty()) {
                while (!toVisit.isEmpty()) {
                    Point p = toVisit.peek();
                    if (p.height > t) {
                        break;
                    }
                    toVisit.poll();
                    if (p.x == grid.length - 1 && p.y == grid[0].length - 1) {
                        return t;
                    }

                    for (int[] dir : dirs) {
                        int newX = p.x + dir[0];
                        int newY = p.y + dir[1];

                        if (0 <= newX && newX < grid.length && 0 <= newY && newY < grid[0].length && !queued[newX][newY]) {
                            toVisit.add(new Point(newX, newY, grid[newX][newY]));
                            queued[newX][newY] = true;
                        }
                    }

                }
                t++;
            }
            return -1;
        }
    }

}
