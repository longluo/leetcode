package com.longluo.contest.weekly_contest_318;

import com.longluo.contest.biweekly_contest_86.Problem1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://leetcode.cn/problems/total-cost-to-hire-k-workers/
 */
public class Problem3 {

    // Simulate time: O(km) space: O(n)
    // TLE
    public static long totalCost_bf(int[] costs, int k, int candidates) {
        List<Integer> list = new ArrayList<>();
        for (int x : costs) {
            list.add(x);
        }

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int len = list.size();

            int min = list.get(0);
            int idx = 0;

            for (int j = 0; j < candidates && j < len; j++) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    idx = j;
                } else if (list.get(j) == min) {
                    idx = Math.min(idx, j);
                }
            }

            for (int j = len - 1; j >= len - candidates && j >= 0; j--) {
                if (list.get(j) < min) {
                    min = list.get(j);
                    idx = j;
                } else if (list.get(j) == min) {
                    idx = Math.min(idx, j);
                }
            }

            ans += min;
            list.remove(idx);
        }

        return ans;
    }

    // PQ
    public static long totalCost(int[] costs, int k, int candidates) {
        int len = costs.length;

        long ans = 0L;

        if (candidates * 2 < len) {
            PriorityQueue<Integer> leftPQ = new PriorityQueue<>();
            int left = 0;
            while (left < candidates) {
                leftPQ.offer(costs[left]);
                left++;
            }

            PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
            int right = len - 1;
            while (right >= len - candidates) {
                rightPQ.offer(costs[right]);
                right--;
            }

            while (k > 0 && right >= left) {
                if (leftPQ.peek() <= rightPQ.peek()) {
                    ans += leftPQ.poll();
                    leftPQ.offer(costs[left]);
                    left++;
                } else {
                    ans += rightPQ.poll();
                    rightPQ.offer(costs[right]);
                    right--;
                }

                k--;
            }

            while (rightPQ.size() > 0) {
                leftPQ.offer(rightPQ.poll());
            }

            while (k > 0) {
                ans += leftPQ.poll();
                k--;
            }
        } else {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                ans += costs[i];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("11 ?= " + totalCost_bf(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println("4 ?= " + totalCost_bf(new int[]{1, 2, 4, 1}, 3, 3));

        System.out.println("11 ?= " + totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        System.out.println("4 ?= " + totalCost(new int[]{1, 2, 4, 1}, 3, 3));
        System.out.println("223 ?= " + totalCost(new int[]{18, 64, 12, 21, 21, 78, 36, 58, 88, 58, 99, 26, 92, 91, 53, 10, 24, 25, 20, 92, 73, 63, 51, 65, 87, 6, 17, 32, 14, 42, 46, 65, 43, 9, 75}, 13, 23));
    }
}
