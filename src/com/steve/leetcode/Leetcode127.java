package com.steve.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Leetcode127 {

    class SolutionOneDirection {

        int NOT_FOUND = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> added = new HashSet<>();
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord)) {
                return NOT_FOUND;
            }

            int transforms = 1;
            List<String> toVisit = new ArrayList<>();
            added.add(beginWord);
            toVisit.add(beginWord);
            while (!toVisit.isEmpty()) {
                List<String> nextVisit = new ArrayList<>();

                for (String curr : toVisit) {
                    if (curr.equals(endWord)) {
                        return transforms;
                    }

                    StringBuilder builder = new StringBuilder(curr);
                    for (int i = 0; i < curr.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == curr.charAt(i)) {
                                continue;
                            }

                            builder.setCharAt(i, c);
                            String next = builder.toString();
                            if (dict.contains(next) && !added.contains(next)) {
                                nextVisit.add(next);
                                added.add(next);
                            }
                        }
                        builder.setCharAt(i, curr.charAt(i));
                    }
                }

                toVisit = nextVisit;
                transforms++;
            }
            return NOT_FOUND;
        }
    }

    class SolutionBiDirection {

        int NOT_FOUND = 0;

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> added = new HashSet<>();
            Set<String> dict = new HashSet<>(wordList);
            if (!dict.contains(endWord)) {
                return NOT_FOUND;
            }

            int transforms = 2;
            Set<String> start = new HashSet<>();
            Set<String> end = new HashSet<>();

            added.add(beginWord);
            added.add(endWord);
            start.add(beginWord);
            end.add(endWord);
            while (!start.isEmpty() && !end.isEmpty()) {
                Set<String> nextVisit = new HashSet<>();

                if (start.size() > end.size()) {
                    Set<String> tmp = start;
                    start = end;
                    end = tmp;
                }

                for (String curr : start) {
                    StringBuilder builder = new StringBuilder(curr);
                    for (int i = 0; i < curr.length(); i++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == curr.charAt(i)) {
                                continue;
                            }

                            builder.setCharAt(i, c);
                            String next = builder.toString();
                            if (end.contains(next)) {
                                return transforms;
                            }
                            if (dict.contains(next) && !added.contains(next)) {
                                nextVisit.add(next);
                                added.add(next);
                            }
                        }
                        builder.setCharAt(i, curr.charAt(i));
                    }
                }

                start = nextVisit;
                transforms++;
            }
            return NOT_FOUND;
        }
    }

}
