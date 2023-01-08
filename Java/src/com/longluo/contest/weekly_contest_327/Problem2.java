package com.longluo.contest.weekly_contest_327;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/contest/weekly-contest-327
 */
public class Problem2 {

    public static long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int x : nums) {
            pq.offer(x);
        }

        long res = 0;
        while (k > 0) {
            int cur = pq.poll();
            res += cur;
            cur = (cur + 2) / 3;
            pq.offer(cur);
            k--;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println("50 ?= " + maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
        System.out.println("17 ?= " + maxKelements(new int[]{1, 10, 3, 3, 3}, 3));
    }
}
