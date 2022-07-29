package com.steve.leetcode;

public class Leetcode2 {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;

            int add = 0;
            while (l1 != null || l2 != null || add > 0) {
                int sum = add;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }
                add = sum / 10;
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            return dummyHead.next;
        }

    }

}
