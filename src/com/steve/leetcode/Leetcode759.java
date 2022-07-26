package com.steve.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Leetcode759 {

    class Solution {
        public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
            // flatten the list of Intervals
            // sort by end
            // try to merge intervals if overlap
            // if no overlap found then between prev and curr is breakdown collect it

            List<Interval> freeTimes = new ArrayList<>();
            List<Interval> workingTimes = new ArrayList<>();
            schedule.stream().forEach(workingTimes::addAll);

            if (workingTimes.size() < 2) {
                return freeTimes;
            }

            Collections.sort(workingTimes, Comparator.comparingInt(interval -> interval.start));
            Interval prev = workingTimes.get(0);
            for (int i = 1; i < workingTimes.size(); i++) {
                Interval curr = workingTimes.get(i);
                if (curr.start <= prev.end) {
                    prev.end = Math.max(prev.end, curr.end);
                } else {
                    freeTimes.add(new Interval(prev.end, curr.start));
                    prev = curr;
                }
            }
            return freeTimes;
        }
    }

}
