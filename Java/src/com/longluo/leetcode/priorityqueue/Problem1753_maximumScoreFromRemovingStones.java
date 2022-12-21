package com.longluo.leetcode.priorityqueue;

import com.longluo.contest.weekly_contest_310.Problem1;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 1753. 移除石子的最大得分
 * <p>
 * 你正在玩一个单人游戏，面前放置着大小分别为 a、b 和 c 的 三堆 石子。
 * <p>
 * 每回合你都要从两个 不同的非空堆 中取出一颗石子，并在得分上加 1 分。当存在 两个或更多 的空堆时，游戏停止。
 * <p>
 * 给你三个整数 a 、b 和 c ，返回可以得到的 最大分数 。
 * <p>
 * 示例 1：
 * 输入：a = 2, b = 4, c = 6
 * 输出：6
 * 解释：石子起始状态是 (2, 4, 6) ，最优的一组操作是：
 * - 从第一和第三堆取，石子状态现在是 (1, 4, 5)
 * - 从第一和第三堆取，石子状态现在是 (0, 4, 4)
 * - 从第二和第三堆取，石子状态现在是 (0, 3, 3)
 * - 从第二和第三堆取，石子状态现在是 (0, 2, 2)
 * - 从第二和第三堆取，石子状态现在是 (0, 1, 1)
 * - 从第二和第三堆取，石子状态现在是 (0, 0, 0)
 * 总分：6 分 。
 * <p>
 * 示例 2：
 * 输入：a = 4, b = 4, c = 6
 * 输出：7
 * 解释：石子起始状态是 (4, 4, 6) ，最优的一组操作是：
 * - 从第一和第二堆取，石子状态现在是 (3, 3, 6)
 * - 从第一和第三堆取，石子状态现在是 (2, 3, 5)
 * - 从第一和第三堆取，石子状态现在是 (1, 3, 4)
 * - 从第一和第三堆取，石子状态现在是 (0, 3, 3)
 * - 从第二和第三堆取，石子状态现在是 (0, 2, 2)
 * - 从第二和第三堆取，石子状态现在是 (0, 1, 1)
 * - 从第二和第三堆取，石子状态现在是 (0, 0, 0)
 * 总分：7 分 。
 * <p>
 * 示例 3：
 * 输入：a = 1, b = 8, c = 8
 * 输出：8
 * 解释：最优的一组操作是连续从第二和第三堆取 8 回合，直到将它们取空。
 * 注意，由于第二和第三堆已经空了，游戏结束，不能继续从第一堆中取石子。
 * <p>
 * 提示：
 * 1 <= a, b, c <= 10^5
 * <p>
 * https://leetcode.cn/problems/maximum-score-from-removing-stones/
 */
public class Problem1753_maximumScoreFromRemovingStones {

    // PQ  time: O(logn) space: O(C)
    public static int maximumScore(int a, int b, int c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a1, b1) -> b1 - a1);

        pq.offer(a);
        pq.offer(b);
        pq.offer(c);

        int ans = 0;

        while (pq.size() >= 2) {
            int biggest = pq.poll();
            int second = pq.poll();

            biggest--;
            second--;

            ans++;

            if (biggest > 0) {
                pq.offer(biggest);
            }

            if (second > 0) {
                pq.offer(second);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + maximumScore(2, 4, 6));
        System.out.println("7 ?= " + maximumScore(4, 4, 6));
        System.out.println("8 ?= " + maximumScore(1, 8, 8));
    }
}
