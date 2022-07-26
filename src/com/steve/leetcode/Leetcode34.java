package com.steve.leetcode;

public class Leetcode34 {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if (nums.length < 1) {
                return new int[] {-1, -1};
            }

            int lowerBound = lowerBound(nums, target);
            int upperBound = upperBound(nums, target);

            if (0 <= lowerBound && lowerBound < nums.length) {
                if (nums[lowerBound] == target) {
                    return new int[] {lowerBound, upperBound};
                }
            }
            return new int[] {-1, -1};
        }

        int lowerBound(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] < target) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
            return lo;
        }

        int upperBound(int[] nums, int target) {
            int lo = 0;
            int hi = nums.length - 1;

            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (nums[mid] > target) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
            return hi;
        }
    }

}
