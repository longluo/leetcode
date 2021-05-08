package com.longluo.leetcode.backtracking;

import java.util.Arrays;

/**
 * 1723. 完成所有工作的最短时间
 * <p>
 * 给你一个整数数组jobs ，其中jobs[i]是完成第i项工作要花费的时间。
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。
 * 工人的 工作时间 是完成分配给他们的所有工作花费时间的总和。请你设计一套最佳的工作分配方案，使工人的 最大工作时间 得以 最小化 。
 * <p>
 * 返回分配方案中尽可能 最小 的 最大工作时间 。
 * <p>
 * 示例 1：
 * 输入：jobs = [3,2,3], k = 3
 * 输出：3
 * 解释：给每位工人分配一项工作，最大工作时间是 3 。
 * <p>
 * 示例 2：
 * 输入：jobs = [1,2,4,7,8], k = 2
 * 输出：11
 * 解释：按下述方式分配工作：
 * 1 号工人：1、2、8（工作时间 = 1 + 2 + 8 = 11）
 * 2 号工人：4、7（工作时间 = 4 + 7 = 11）
 * 最大工作时间是 11 。
 * <p>
 * 提示：
 * 1 <= k <= jobs.length <= 12
 * 1 <= jobs[i] <= 10^7
 * <p>
 * https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 */
public class Problem1723_findMinimumTimeToFinishAllJobs {

    public static int minimumTimeRequired(int[] jobs, int k) {
        if (jobs == null || jobs.length == 0) {
            return 0;
        }

        int n = jobs.length;
        if (n == 1) {
            return jobs[0];
        }

        int sum = 0;
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            sum += jobs[i];
            maxVal = Math.max(maxVal, jobs[i]);
        }

        Arrays.sort(jobs);
        if (k >= n) {
            return maxVal;
        }

        int low = 0;
        int high = n - 1;
        while (low < high) {
            int temp = jobs[low];
            jobs[low] = jobs[high];
            jobs[high] = temp;
            low++;
            high--;
        }

        int left = 0;
        int right = sum;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(jobs, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static boolean check(int[] jobs, int k, int limit) {
        int[] workers = new int[k];
        return backtracking(jobs, workers, 0, limit);
    }

    public static boolean backtracking(int[] jobs, int[] workers, int index, int limit) {
        if (index >= jobs.length) {
            return true;
        }

        int curr = jobs[index];
        for (int j = 0; j < workers.length; ++j) {
            if (workers[j] + curr <= limit) {
                workers[j] += curr;
                if (backtracking(jobs, workers, index + 1, limit)) {
                    return true;
                }
                workers[j] -= curr;
            }
            // 如果当前工人未被分配工作，那么下一个工人也必然未被分配工作
            // 或者当前工作恰能使该工人的工作量达到了上限
            // 这两种情况下我们无需尝试继续分配工作
            if (workers[j] == 0 || workers[j] + curr == limit) {
                break;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minimumTimeRequired(new int[]{3, 2, 3}, 3));
        System.out.println("11 ?= " + minimumTimeRequired(new int[]{1, 2, 4, 7, 8}, 2));
        System.out.println("29 ?= " + minimumTimeRequired(new int[]{12, 13, 14, 17, 25}, 3));
        System.out.println("2983466 ?= " + minimumTimeRequired(new int[]{1677980, 2092151, 1305486, 2623376, 2844139}, 4));

        System.out.println(" " + 5 / 2);
        float a = (float) 10 / 3;
        float b = (float) 10 / 5;
        int c = (int) b;
        System.out.println("a = " + a);
        System.out.println(a == (int) a);
        System.out.println("b = " + b);
        System.out.println(b == (int) b);
        System.out.println("c = " + c);
        System.out.println(c == (int) c);
    }
}
