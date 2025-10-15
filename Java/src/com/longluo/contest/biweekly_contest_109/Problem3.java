package com.longluo.contest.biweekly_contest_109;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.cn/contest/biweekly-contest-109
 */
public class Problem3 {

    public static long maxScore(int[] nums, int x) {
        int len = nums.length;

        long score = nums[0];

        long max = score;

        Queue<long[]> queue = new LinkedList<>();
        queue.offer(new long[]{0, score});

        while (!queue.isEmpty()) {
            long[] cur = queue.poll();

            long idx = cur[0];
            long curScore = cur[1];

            for (long i = idx + 1; i < len; i++) {
                long sum = (long) nums[(int) idx] + (long) nums[(int) i];

                curScore += nums[(int) i];

                if (sum % 2 != 0) {
                    curScore -= x;
                }

                max = Math.max(max, curScore);

                queue.offer(new long[]{i, curScore});
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("13 ?= " + maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
        System.out.println("20 ?= " + maxScore(new int[]{2, 4, 6, 8}, 3));
    }
}
