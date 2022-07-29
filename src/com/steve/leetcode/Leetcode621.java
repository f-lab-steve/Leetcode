package com.steve.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Leetcode621 {

    class Solution {

        class Tuple {
            char c;
            int n;
            int nextAvailable;

            Tuple(char c, int n) {
                this.c = c;
                this.n = n;
            }
        }

        public int leastInterval(char[] tasks, int n) {
            Tuple[] tuples = new Tuple[26];
            for (char task : tasks) {
                Tuple t = tuples[task - 'A'];
                if (t == null) {
                    tuples[task - 'A'] = t = new Tuple(task, 0);
                }
                t.n++;
            }

            PriorityQueue<Tuple> taskQueue = new PriorityQueue<>(Comparator.comparingInt((Tuple t) -> t.n).reversed());
            PriorityQueue<Tuple> idleQueue = new PriorityQueue<>(Comparator.comparingInt((Tuple t) -> t.nextAvailable));
            for (Tuple t : tuples) {
                if (t != null) {
                    taskQueue.offer(t);
                }
            }

            int time = 0;
            while (!taskQueue.isEmpty() || !idleQueue.isEmpty()) {
                time++;
                while(!idleQueue.isEmpty() && idleQueue.peek().nextAvailable <= time) {
                    taskQueue.offer(idleQueue.poll());
                }

                if (!taskQueue.isEmpty()) {
                    Tuple task = taskQueue.poll();
                    task.n--;
                    if (task.n > 0) {
                        task.nextAvailable = time + n + 1;
                        idleQueue.offer(task);
                    }
                }
            }
            return time;
        }
    }

}
