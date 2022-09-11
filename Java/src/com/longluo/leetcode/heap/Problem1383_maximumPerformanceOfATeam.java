package com.longluo.leetcode.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1383. 最大的团队表现值
 * <p>
 * 公司有编号为 1 到 n 的 n 个工程师，给你两个数组 speed 和 efficiency ，
 * 其中 speed[i] 和 efficiency[i] 分别代表第 i 位工程师的速度和效率。请你返回由最多 k 个工程师组成的最大团队表现值 ，
 * 由于答案可能很大，请你返回结果对 10^9 + 7 取余后的结果。
 * <p>
 * 团队表现值 的定义为：一个团队中「所有工程师速度的和」乘以他们「效率值中的最小值」。
 * <p>
 * 示例 1：
 * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 2
 * 输出：60
 * 解释：
 * 我们选择工程师 2（speed=10 且 efficiency=4）和工程师 5（speed=5 且 efficiency=7）。他们的团队表现值为 performance = (10 + 5) * min(4, 7) = 60 。
 * <p>
 * 示例 2：
 * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 3
 * 输出：68
 * 解释：
 * 此示例与第一个示例相同，除了 k = 3 。我们可以选择工程师 1 ，工程师 2 和工程师 5 得到最大的团队表现值。表现值为 performance = (2 + 10 + 5) * min(5, 4, 7) = 68 。
 * <p>
 * 示例 3：
 * 输入：n = 6, speed = [2,10,3,1,5,8], efficiency = [5,4,3,9,7,2], k = 4
 * 输出：72
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * speed.length == n
 * efficiency.length == n
 * 1 <= speed[i] <= 10^5
 * 1 <= efficiency[i] <= 10^8
 * 1 <= k <= n
 * <p>
 * https://leetcode.cn/problems/maximum-performance-of-a-team/
 */
public class Problem1383_maximumPerformanceOfATeam {

    // Greedy + Sorted time: O(nlogn) space: O(n)
    public static int maxPerformance_greedy(int n, int[] speed, int[] efficiency, int k) {
        int mod = 1_000_000_007;

        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = speed[i];
            sorted[i][1] = efficiency[i];
        }

        Arrays.sort(sorted, (o1, o2) -> o2[1] - o1[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        long ans = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (pq.size() > k - 1) {
                sum -= pq.poll();
            }

            ans = Math.max(ans, (sum + sorted[i][0]) * sorted[i][1]);
            pq.offer(sorted[i][0]);
            sum += sorted[i][0];
        }

        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        System.out.println("60 ?= " + maxPerformance_greedy(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
    }
}
