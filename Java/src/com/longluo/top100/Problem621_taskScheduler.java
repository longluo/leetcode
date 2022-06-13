package com.longluo.top100;

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
 * https://leetcode.com/problems/task-scheduler/
 */
public class Problem621_taskScheduler {

    // Simulate + Greedy time: O(tasks * C) space: O(C)
    public static int leastInterval_greedy(char[] tasks, int n) {
        int len = tasks.length;
        if (n == 0) {
            return len;
        }

        int[] cnt = new int[26];
        for (char task : tasks) {
            cnt[task - 'A']++;
        }

        Arrays.sort(cnt);

        int min = 0;
        int size = tasks.length;
        while (size > 0) {
            int roundTime = 0;
            for (int i = 25; i >= 0; i--) {
                if (cnt[i] > 0) {
                    roundTime++;
                    cnt[i]--;
                    size--;
                }

                if (roundTime > n) {
                    break;
                }
            }

            Arrays.sort(cnt);
            min += size == 0 ? roundTime : Math.max(roundTime, n + 1);
        }

        return min;
    }

    // PQ time: O(nC) space: O(n)
    public static int leastInterval_pq(char[] tasks, int n) {
        int[] counts = new int[26];
        for (char task : tasks) {
            counts[task - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int x : counts) {
            if (x > 0) {
                pq.offer(x);
            }
        }

        int min = 0;
        int cycle = n + 1;
        while (!pq.isEmpty()) {
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < cycle; i++) {
                if (!pq.isEmpty()) {
                    queue.offer(pq.poll());
                    count++;
                }
            }

            while (!queue.isEmpty()) {
                int freq = queue.poll();
                freq--;
                if (freq > 0) {
                    pq.offer(freq);
                }
            }

            min += pq.isEmpty() ? count : cycle;
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

    // Math Set O(n + 26) space: O(26)
    public static int leastInterval_math_set(char[] tasks, int n) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int maxTimes = 0;
        for (char task : tasks) {
            int times = freqMap.getOrDefault(task, 0) + 1;
            freqMap.put(task, times);
            maxTimes = Math.max(maxTimes, times);
        }

        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            int value = entry.getValue();
            if (value == maxTimes) {
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
        System.out.println("16 ?= " + leastInterval_pq(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));

        System.out.println("8 ?= " + leastInterval_math(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println("6 ?= " + leastInterval_math(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));

        System.out.println("6 ?= " + leastInterval_math_set(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
    }
}
