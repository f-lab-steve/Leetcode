package com.steve.leetcode;

public class Leetcode19 {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode follower = head;
            ListNode leader = head;

            for (int i = 0; i < n && leader != null; i++) {
                leader = leader.next;
            }

            ListNode prev = null;
            while (leader != null) {
                leader = leader.next;
                prev = follower;
                follower = follower.next;
            }

            if (prev == null) {
                return follower.next;
            }

            prev.next = follower.next;
            return head;
        }
    }

}
