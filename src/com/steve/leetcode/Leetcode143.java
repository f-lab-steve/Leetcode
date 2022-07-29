package com.steve.leetcode;

public class Leetcode143 {

    class Solution {
        public void reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode reversed = reverse(slow.next);
            if (slow != null) {
                slow.next = null;
            }

            ListNode first = head;
            ListNode second = reversed;

            while (second != null) {
                ListNode firstNext = first.next;
                ListNode secondNext = second.next;
                first.next = second;
                second.next = firstNext;
                second = secondNext;
                first = firstNext;
            }
        }

        ListNode reverse(ListNode node) {
            ListNode newHead = null;
            while (node != null) {
                ListNode next = node.next;
                node.next = newHead;
                newHead = node;
                node = next;
            }
            return newHead;
        }
    }

}
