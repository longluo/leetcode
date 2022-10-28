package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1335. 工作计划的最低难度
 * <p>
 * 你需要制定一份 d 天的工作计划表。工作之间存在依赖，要想执行第 i 项工作，你必须完成全部 j 项工作（ 0 <= j < i）。
 * <p>
 * 你每天 至少 需要完成一项任务。工作计划的总难度是这 d 天每一天的难度之和，而一天的工作难度是当天应该完成工作的最大难度。
 * <p>
 * 给你一个整数数组 jobDifficulty 和一个整数 d，分别代表工作难度和需要计划的天数。第 i 项工作的难度是 jobDifficulty[i]。
 * <p>
 * 返回整个工作计划的 最小难度 。如果无法制定工作计划，则返回 -1 。
 * <p>
 * 示例 1：
 * 输入：jobDifficulty = [6,5,4,3,2,1], d = 2
 * 输出：7
 * 解释：第一天，您可以完成前 5 项工作，总难度 = 6.
 * 第二天，您可以完成最后一项工作，总难度 = 1.
 * 计划表的难度 = 6 + 1 = 7
 * <p>
 * 示例 2：
 * 输入：jobDifficulty = [9,9,9], d = 4
 * 输出：-1
 * 解释：就算你每天完成一项工作，仍然有一天是空闲的，你无法制定一份能够满足既定工作时间的计划表。
 * <p>
 * 示例 3：
 * 输入：jobDifficulty = [1,1,1], d = 3
 * 输出：3
 * 解释：工作计划为每天一项工作，总难度为 3 。
 * <p>
 * 示例 4：
 * 输入：jobDifficulty = [7,1,7,1,7,1], d = 3
 * 输出：15
 * <p>
 * 示例 5：
 * 输入：jobDifficulty = [11,111,22,222,33,333,44,444], d = 6
 * 输出：843
 * <p>
 * 提示：
 * 1 <= jobDifficulty.length <= 300
 * 0 <= jobDifficulty[i] <= 1000
 * 1 <= d <= 10
 * <p>
 * https://leetcode.cn/problems/minimum-difficulty-of-a-job-schedule/
 */
public class Problem1335_minimumDifficultyOfAJobSchedule {

    // BF time: O(n^2) space: O(n)
    // TLE
    public static int minDifficulty(int[] jobDifficulty, int d) {
        int len = jobDifficulty.length;
        if (len < d) {
            return -1;
        }

        if (d <= 1) {
            return Arrays.stream(jobDifficulty).max().getAsInt();
        }

        List<List<Integer>> res = new ArrayList<>();

        backtrack(res, new ArrayList<Integer>(), jobDifficulty, 1, d - 1);

        int min = Integer.MAX_VALUE;

        for (List<Integer> path : res) {
            int sum = 0;

            int size = path.size();

            int maxDiff = jobDifficulty[0];
            for (int i = 0; i < path.get(0); i++) {
                maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            }

            sum += maxDiff;
            for (int i = 0; i < size - 1; i++) {
                maxDiff = jobDifficulty[path.get(i)];
                for (int j = path.get(i); j < path.get(i + 1); j++) {
                    maxDiff = Math.max(maxDiff, jobDifficulty[j]);
                }

                sum += maxDiff;
            }

            maxDiff = jobDifficulty[len - 1];
            for (int i = path.get(size - 1); i < len; i++) {
                maxDiff = Math.max(maxDiff, jobDifficulty[i]);
            }
            sum += maxDiff;

            min = Math.min(min, sum);
        }

        return min;
    }

    private static void backtrack(List<List<Integer>> res, List<Integer> path, int[] nums, int start, int sum) {
        int len = nums.length;

        if (sum == path.size()) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (start > len) {
            return;
        }

        for (int i = start; i < len; i++) {
            if (path.size() > 0 && i <= path.get(path.size() - 1)) {
                continue;
            }

            path.add(i);
            backtrack(res, path, nums, i + 1, sum);
            path.remove(path.size() - 1);

            backtrack(res, path, nums, i + 1, sum);
        }
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + minDifficulty(new int[]{3}, 1));
        System.out.println("7 ?= " + minDifficulty(new int[]{6, 5, 4, 3, 2, 1}, 2));
        System.out.println("15 ?= " + minDifficulty(new int[]{7, 1, 7, 1, 7, 1}, 3));
        System.out.println("-1 ?= " + minDifficulty(new int[]{9, 9, 9}, 4));
    }
}
