package com.longluo.contest.biweekly_contest_94;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-94
 */

public class Problem2 {

    public static List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report, int[] student_id, int k) {
        Set<String> positiveSet = new HashSet<>();
        Set<String> negativeSet = new HashSet<>();

        for (String word : positive_feedback) {
            positiveSet.add(word);
        }

        for (String word : negative_feedback) {
            negativeSet.add(word);
        }

        Map<Integer, Integer> scoreMap = new HashMap<>();

        for (int i = 0; i < report.length; i++) {
            int id = student_id[i];
            String sentence = report[i];
            String[] words = sentence.split("\\s+");

            int score = 0;

            for (String x : words) {
                if (positiveSet.contains(x)) {
                    score += 3;
                } else if (negativeSet.contains(x)) {
                    score -= 1;
                }
            }

            scoreMap.put(id, score);
        }

        List<Integer> ans = new ArrayList<>();
        for (int x : student_id) {
            ans.add(x);
        }

        Collections.sort(ans, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if (scoreMap.get(a) == scoreMap.get(b)) {
                    return a - b;
                }
                return scoreMap.get(b) - scoreMap.get(a);
            }
        });

        return ans.subList(0, k);
    }

    public static void main(String[] args) {
        System.out.println("[1, 2] ?= " + topStudents(new String[]{"smart", "brilliant", "studious"}, new String[]{"not"}, new String[]{"this student is studious", "the student is smart"}, new int[]{1, 2}, 2));
    }
}
