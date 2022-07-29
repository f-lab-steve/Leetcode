package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Leetcode23 {

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists.length == 0) {
                return null;
            }

            List<ListNode> toMerge = Arrays.stream(lists).collect(Collectors.toList());
            while (toMerge.size() > 1) {
                List<ListNode> result = new ArrayList<>();
                for (int i = 0; i < toMerge.size(); i += 2) {
                    if (i + 1 < toMerge.size()) {
                        result.add(merge(toMerge.get(i), toMerge.get(i + 1)));
                    } else {
                        result.add(toMerge.get(i));
                    }
                }
                toMerge = result;
            }
            return toMerge.get(0);
        }

        ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummyNode = new ListNode();
            ListNode tail = dummyNode;

            while (l1 != null && l2 != null) {
                ListNode next;
                if (l1.val < l2.val) {
                    next = l1;
                    l1 = l1.next;
                } else {
                    next = l2;
                    l2 = l2.next;
                }
                tail.next = next;
                tail = next;
            }
            tail.next = l1 == null ? l2 : l1;
            return dummyNode.next;
        }
    }

}
