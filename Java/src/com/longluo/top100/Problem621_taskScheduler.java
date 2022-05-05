package com.longluo.top100;

import com.longluo.datastructure.ArrayUtils;

import java.util.*;

/**
 * 621. 任务调度器
 * <p>
 * 给定一个用字符数组表示的 CPU 需要执行的任务列表。其中包含使用大写的 A - Z 字母表示的26 种不同种类的任务。
 * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。CPU 在任何一个单位时间内都可以执行一个任务，
 * 或者在待命状态。
 * 然而，两个相同种类的任务之间必须有长度为 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
 * 你需要计算完成所有任务所需要的最短时间。
 * <p>
 * 示例 ：
 * 输入：tasks = ["A","A","A","B","B","B"], n = 2
 * 输出：8
 * 解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B.
 * 在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，
 * 所以中间出现了（待命）状态。
 * <p>
 * 提示：
 * 任务的总个数为 [1, 10000]。
 * n的取值范围为 [0, 100]。
 * <p>
 * https://leetcode-cn.com/problems/task-scheduler/
 */
public class Problem621_taskScheduler {

    // BF
    public static int leastInterval_greedy(char[] tasks, int n) {
        if (tasks == null || tasks.length <= 1 || n == 0) {
            return tasks.length;
        }

        int len = tasks.length;
        int min = 0;
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++) {
            count[i][0] = i;
        }

        for (char task : tasks) {
            count[task - 'A'][1]++;
        }

        Arrays.sort(count, (o1, o2) -> o1[1] - o2[1]);
        int idx = 0;
        while (true) {
            if (len == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                count[i][1]--;
                len--;
                min++;
                if (len == 0) {
                    break;
                }
            }
        }

        return min;
    }

    // PQ
    public static int leastInterval_pq(char[] tasks, int n) {
        if (tasks == null || tasks.length <= 1 || n == 0) {
            return tasks.length;
        }

        int len = tasks.length;
        int min = 0;
        int[] count = new int[26];
        for (char ch : tasks) {
            count[ch - 'A']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new int[]{i, count[i]});
            }
        }

        return min;
    }

    // Math time: O(nlogn+n)=O(nlogn) space: O(n + logn)=O(n)
    public static int leastInterval_math(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        Arrays.sort(count);
        int maxTimes = count[25];
        int maxCount = 0;
        for (int x : count) {
            if (x == maxTimes) {
                maxCount++;
            }
        }

        int ans = (maxTimes - 1) * (n + 1) + maxCount;
        return Math.max(ans, tasks.length);
    }

    public static void main(String[] args) {
        System.out.println("8 ?= " + leastInterval_greedy(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("16 ?= " + leastInterval_greedy(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));

        System.out.println("8 ?= " + leastInterval_pq(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));

        System.out.println("8 ?= " + leastInterval_math(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("6 ?= " + leastInterval_math(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }
}
