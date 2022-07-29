package com.steve.leetcode;

public class Leetcode25 {

    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode nextReverse = head;
            int jumps = k;
            while (jumps > 0 && nextReverse != null) {
                nextReverse = nextReverse.next;
                jumps--;
            }

            if (jumps > 0) {
                return head;
            }

            ListNode newHead = null;
            ListNode prevHead = head;
            ListNode tail = head;
            while (prevHead != nextReverse) {
                ListNode next = prevHead.next;
                prevHead.next = newHead;
                newHead = prevHead;
                prevHead = next;
            }

            tail.next = reverseKGroup(nextReverse, k);
            return newHead;
        }
    }

}
