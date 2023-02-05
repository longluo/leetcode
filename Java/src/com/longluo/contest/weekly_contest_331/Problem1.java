package com.longluo.contest.weekly_contest_331;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/contest/weekly-contest-331
 */
public class Problem1 {

    public static long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for (int x : gifts) {
            pq.offer(x);
        }

        while (k > 0) {
            int cur = pq.poll();
            int sqrt = (int) Math.sqrt(cur);
            if (cur >= sqrt) {
                pq.offer(sqrt);
            } else {
                pq.offer(cur);
            }

            k--;
        }

        long ans = 0;
        while (!pq.isEmpty()) {
            ans += pq.poll();
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("29 ?= " + pickGifts(new int[]{25, 64, 9, 4, 100}, 4));
    }
}
