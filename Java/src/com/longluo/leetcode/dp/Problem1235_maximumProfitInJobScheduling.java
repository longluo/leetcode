package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1235. 规划兼职工作
 * <p>
 * 你打算利用空闲时间来做兼职工作赚些零花钱。
 * <p>
 * 这里有 n 份兼职工作，每份工作预计从 startTime[i] 开始到 endTime[i] 结束，报酬为 profit[i]。
 * <p>
 * 给你一份兼职工作表，包含开始时间 startTime，结束时间 endTime 和预计报酬 profit 三个数组，
 * 请你计算并返回可以获得的最大报酬。
 * <p>
 * 注意，时间上出现重叠的 2 份工作不能同时进行。
 * <p>
 * 如果你选择的工作在时间 X 结束，那么你可以立刻进行在时间 X 开始的下一份工作。
 * <p>
 * 示例 1：
 * 输入：startTime = [1,2,3,3], endTime = [3,4,5,6], profit = [50,10,40,70]
 * 输出：120
 * 解释：
 * 我们选出第 1 份和第 4 份工作，
 * 时间范围是 [1-3]+[3-6]，共获得报酬 120 = 50 + 70。
 * <p>
 * 示例 2：
 * 输入：startTime = [1,2,3,4,6], endTime = [3,5,10,6,9], profit = [20,20,100,70,60]
 * 输出：150
 * 解释：
 * 我们选择第 1，4，5 份工作。
 * 共获得报酬 150 = 20 + 70 + 60。
 * <p>
 * 示例 3：
 * 输入：startTime = [1,1,1], endTime = [2,3,4], profit = [5,6,4]
 * 输出：6
 * <p>
 * 提示：
 * 1 <= startTime.length == endTime.length == profit.length <= 5 * 10^4
 * 1 <= startTime[i] < endTime[i] <= 10^9
 * 1 <= profit[i] <= 10^4
 * <p>
 * https://leetcode.cn/problems/maximum-profit-in-job-scheduling/
 */
public class Problem1235_maximumProfitInJobScheduling {

    // BF Backtracking time: O(n^2) space: O(n)
    // TLE
    public static int jobScheduling_bf(int[] startTime, int[] endTime, int[] profit) {
        int len = startTime.length;

        int[][] sorted = new int[len][3];
        for (int i = 0; i < len; i++) {
            sorted[i][0] = startTime[i];
            sorted[i][1] = endTime[i];
            sorted[i][2] = profit[i];
        }

        Arrays.sort(sorted, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });

        int maxProfit = 0;

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<>(), sorted, 0);

        for (List<Integer> schedule : res) {
            int sum = 0;
            for (int x : schedule) {
                sum += sorted[x][2];
            }

            maxProfit = Math.max(maxProfit, sum);
        }

        return maxProfit;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[][] jobs, int start) {
        int len = jobs.length;
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (path.size() > 0) {
                int endTime = jobs[path.get(path.size() - 1)][1];
                if (jobs[i][0] < endTime) {
                    if (i == len - 1) {
                        res.add(new ArrayList<>(path));
                    }
                    continue;
                }
            }

            path.add(i);
            backtrack(res, path, jobs, i + 1);
            path.remove(path.size() - 1);

            backtrack(res, path, jobs, i + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + jobScheduling_bf(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}));
        System.out.println("120 ?= " + jobScheduling_bf(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}));
        System.out.println("150 ?= " + jobScheduling_bf(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}));
    }
}
