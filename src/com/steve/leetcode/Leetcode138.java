package com.steve.leetcode;

public class Leetcode138 {

    class Solution {
        public Node copyRandomList(Node head) {

            // pass1 -> copy & interweive
            // pass2 -> fill random pointer
            // pass3 -> split

            Node curr = head;
            while (curr != null) {
                Node next = curr.next;
                Node newNode = new Node(curr.val);
                curr.next = newNode;
                newNode.next = next;
                curr = next;
            }

            curr = head;
            while (curr != null) {
                Node newNode = curr.next;
                newNode.random = curr.random == null ? null : curr.random.next;
                curr = curr.next.next;
            }

            Node dummyHead = new Node(-1);
            Node tail = dummyHead;
            curr = head;
            while (curr != null) {
                tail.next = curr.next;
                tail = tail.next;
                curr.next = curr.next.next;
                curr = curr.next;
            }
            return dummyHead.next;
        }
    }

}
