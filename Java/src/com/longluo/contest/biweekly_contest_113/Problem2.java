package com.longluo.contest.biweekly_contest_113;

import java.util.*;

/**
 * https://leetcode.cn/contest/biweekly-contest-113
 */
public class Problem2 {

    public static int minLengthAfterRemovals(List<Integer> nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a;
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry.getValue());
        }

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            if (first > second) {
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        List<Integer> tst1 = new ArrayList<>();
        tst1.add(1);
        tst1.add(1);
        tst1.add(2);

        System.out.println("1 ?= " + minLengthAfterRemovals(tst1));

        List<Integer> tst2 = new ArrayList<>();
        tst2.add(1);
        tst2.add(1);

        System.out.println("2 ?= " + minLengthAfterRemovals(tst2));
    }
}
