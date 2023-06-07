package com.longluo.contest.weekly_contest_339;

/**
 * https://leetcode.cn/contest/weekly-contest-339
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2611. 老鼠和奶酪
 * <p>
 * 有两只老鼠和 n 块不同类型的奶酪，每块奶酪都只能被其中一只老鼠吃掉。
 * <p>
 * 下标为 i 处的奶酪被吃掉的得分为：
 * 如果第一只老鼠吃掉，则得分为 reward1[i] 。
 * 如果第二只老鼠吃掉，则得分为 reward2[i] 。
 * 给你一个正整数数组 reward1 ，一个正整数数组 reward2 ，和一个非负整数 k 。
 * <p>
 * 请你返回第一只老鼠恰好吃掉 k 块奶酪的情况下，最大 得分为多少。
 * <p>
 * 示例 1：
 * 输入：reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
 * 输出：15
 * 解释：这个例子中，第一只老鼠吃掉第 2 和 3 块奶酪（下标从 0 开始），第二只老鼠吃掉第 0 和 1 块奶酪。
 * 总得分为 4 + 4 + 3 + 4 = 15 。
 * 15 是最高得分。
 * <p>
 * 示例 2：
 * 输入：reward1 = [1,1], reward2 = [1,1], k = 2
 * 输出：2
 * 解释：这个例子中，第一只老鼠吃掉第 0 和 1 块奶酪（下标从 0 开始），第二只老鼠不吃任何奶酪。
 * 总得分为 1 + 1 = 2 。
 * 2 是最高得分。
 * <p>
 * 提示：
 * 1 <= n == reward1.length == reward2.length <= 10^5
 * 1 <= reward1[i], reward2[i] <= 1000
 * 0 <= k <= n
 * <p>
 * https://leetcode.cn/problems/count-the-number-of-beautiful-subarrays/
 */
public class Problem2611_miceAndCheese {

    // Sorting time: O(nlogn) space: O(n)
    public static int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        int[][] scores = new int[n][2];

        for (int i = 0; i < n; i++) {
            scores[i][0] = i;
            scores[i][1] = reward1[i] - reward2[i];
        }

        Arrays.sort(scores, (a, b) -> b[1] - a[1]);

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans += reward1[scores[i][0]];
        }

        for (int i = k; i < n; i++) {
            ans += reward2[scores[i][0]];
        }

        return ans;
    }

    public static int miceAndCheese_pq(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return (reward1[b] - reward2[b]) - (reward1[a] - reward2[a]);
            }
        });

        for (int i = 0; i < n; i++) {
            pq.offer(i);
        }

        int ans = 0;

        for (int i = 0; i < k; i++) {
            ans += reward1[pq.poll()];
        }

        for (int i = k; i < n; i++) {
            ans += reward2[pq.poll()];
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + miceAndCheese(new int[]{1, 1}, new int[]{1, 1}, 2));
        System.out.println("15 ?= " + miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));

        System.out.println("2 ?= " + miceAndCheese_pq(new int[]{1, 1}, new int[]{1, 1}, 2));
        System.out.println("15 ?= " + miceAndCheese_pq(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
    }
}