package com.steve.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode146 {

    class LRUCache {

        class Node {
            int key;
            int val;
            Node next;
            Node prev;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }

        int capacity;
        Node head;
        Node tail;

        Map<Integer, Node> values = new HashMap<>();

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.head = new Node(-1, -1);
            this.tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            Node node = values.get(key);
            if (node == null) {
                return -1;
            }
            refresh(node);
            return node.val;
        }

        public void put(int key, int value) {
            Node node = values.get(key);
            if (node != null) {
                refresh(node);
                node.val = value;
            } else {
                Node newNode = new Node(key, value);
                addFirst(newNode);
                values.put(key, newNode);
                if (values.size() > capacity) {
                    Node evicted = removeLast();
                    values.remove(evicted.key);
                }
            }
        }

        void refresh(Node node) {
            remove(node);
            addFirst(node);
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        void addFirst(Node node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        Node removeLast() {
            if (head.next != tail) {
                Node removed = tail.prev;
                remove(removed);
                return removed;
            }
            return null;
        }
    }

}
