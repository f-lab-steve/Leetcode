package com.steve.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode973 {

    class Solution {

        public int[][] kClosest(int[][] points, int k) {

            PriorityQueue<long[]> longer = new PriorityQueue<>(Comparator.comparingLong((long[] i) -> i[2]).reversed());

            for (int[] point : points) {
                long[] pointWithDistance = new long[3];
                pointWithDistance[0] = point[0];
                pointWithDistance[1] = point[1];
                pointWithDistance[2] = point[0] * point[0] + point[1] * point[1];

                longer.offer(pointWithDistance);

                if (longer.size() > k) {
                    longer.poll();
                }
            }
            int[][] result = new int[longer.size()][2];
            int i = 0;
            while (!longer.isEmpty()) {
                long[] point = longer.poll();
                result[i][0] = (int)point[0];
                result[i][1] = (int)point[1];
                i++;
            }
            return result;
        }
    }

}
