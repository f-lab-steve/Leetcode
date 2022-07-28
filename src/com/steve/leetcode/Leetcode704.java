package com.steve.leetcode;

public class Leetcode704 {

    class Solution {
        public int search(int[] nums, int target) {
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

            if (0 <= lo && lo < nums.length && nums[lo] == target) {
                return lo;
            }
            return -1;
        }
    }

}
