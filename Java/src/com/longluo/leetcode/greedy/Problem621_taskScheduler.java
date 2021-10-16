package com.longluo.leetcode.greedy;

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
 */
public class Problem621_taskScheduler {

    public static int leastInterval(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        int ans = 0;


        return ans;
    }

    public static void main(String[] args) {

    }
}
