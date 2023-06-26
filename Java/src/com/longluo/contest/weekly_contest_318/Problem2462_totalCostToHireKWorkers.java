package com.longluo.contest.weekly_contest_318;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2462. 雇佣 K 位工人的总代价
 * <p>
 * 给你一个下标从 0 开始的整数数组 costs ，其中 costs[i] 是雇佣第 i 位工人的代价。
 * <p>
 * 同时给你两个整数 k 和 candidates 。我们想根据以下规则恰好雇佣 k 位工人：
 * <p>
 * 总共进行 k 轮雇佣，且每一轮恰好雇佣一位工人。
 * <p>
 * 在每一轮雇佣中，从最前面 candidates 和最后面 candidates 人中选出代价最小的一位工人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 比方说，costs = [3,2,7,7,1,2] 且 candidates = 2 ，第一轮雇佣中，我们选择第 4 位工人，因为他的代价最小 [3,2,7,7,1,2] 。
 * 第二轮雇佣，我们选择第 1 位工人，因为他们的代价与第 4 位工人一样都是最小代价，而且下标更小，[3,2,7,7,2] 。注意每一轮雇佣后，剩余工人的下标可能会发生变化。
 * 如果剩余员工数目不足 candidates 人，那么下一轮雇佣他们中代价最小的一人，如果有多位代价相同且最小的工人，选择下标更小的一位工人。
 * 一位工人只能被选择一次。
 * <p>
 * 返回雇佣恰好 k 位工人的总代价。
 * <p>
 * 示例 1：
 * 输入：costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
 * 输出：11
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [17,12,10,2,7,2,11,20,8] 中选择。最小代价是 2 ，有两位工人，我们选择下标更小的一位工人，即第 3 位工人。总代价是 0 + 2 = 2 。
 * - 第二轮雇佣，我们从 [17,12,10,7,2,11,20,8] 中选择。最小代价是 2 ，下标为 4 ，总代价是 2 + 2 = 4 。
 * - 第三轮雇佣，我们从 [17,12,10,7,11,20,8] 中选择，最小代价是 7 ，下标为 3 ，总代价是 4 + 7 = 11 。注意下标为 3 的工人同时在最前面和最后面 4 位工人中。
 * 总雇佣代价是 11 。
 * <p>
 * 示例 2：
 * 输入：costs = [1,2,4,1], k = 3, candidates = 3
 * 输出：4
 * 解释：我们总共雇佣 3 位工人。总代价一开始为 0 。
 * - 第一轮雇佣，我们从 [1,2,4,1] 中选择。最小代价为 1 ，有两位工人，我们选择下标更小的一位工人，即第 0 位工人，总代价是 0 + 1 = 1 。注意，下标为 1 和 2 的工人同时在最前面和最后面 3 位工人中。
 * - 第二轮雇佣，我们从 [2,4,1] 中选择。最小代价为 1 ，下标为 2 ，总代价是 1 + 1 = 2 。
 * - 第三轮雇佣，少于 3 位工人，我们从剩余工人 [2,4] 中选择。最小代价是 2 ，下标为 0 。总代价为 2 + 2 = 4 。
 * 总雇佣代价是 4 。
 * <p>
 * 提示：
 * 1 <= costs.length <= 10^5
 * 1 <= costs[i] <= 10^5
 * 1 <= k, candidates <= costs.length
 * <p>
 * https://leetcode.cn/problems/total-cost-to-hire-k-workers/
 */
public class Problem2462_totalCostToHireKWorkers {

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

    // Simulate time: O(km) space: O(n)
    // TLE
    public static long totalCost_simu(int[] costs, int k, int candidates) {
        int n = costs.length;

        boolean[] seen = new boolean[n];

        long ans = 0;

        for (int i = 0; i < k; i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;


            for (int j = 0, m = candidates; j < n && m > 0; j++) {
                if (seen[j]) {
                    continue;
                }

                m--;

                if (costs[j] < min) {
                    min = costs[j];
                    idx = j;
                }
            }

            for (int j = n - 1, m = candidates; j >= 0 && m > 0; j--) {
                if (seen[j]) {
                    continue;
                }

                m--;

                if (costs[j] < min) {
                    min = costs[j];
                    idx = j;
                }
            }

            ans += min;
            seen[idx] = true;
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

        System.out.println("11 ?= " + totalCost_simu(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
    }
}
