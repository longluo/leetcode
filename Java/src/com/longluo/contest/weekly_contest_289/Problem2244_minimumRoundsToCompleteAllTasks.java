package com.longluo.contest.weekly_contest_289;

import java.util.HashMap;
import java.util.Map;

/**
 * 2244. 完成所有任务需要的最少轮数
 * <p>
 * 给你一个下标从 0 开始的整数数组 tasks ，其中 tasks[i] 表示任务的难度级别。在每一轮中，
 * 你可以完成 2 个或者 3 个 相同难度级别 的任务。
 * <p>
 * 返回完成所有任务需要的 最少 轮数，如果无法完成所有任务，返回 -1 。
 * <p>
 * 示例 1：
 * 输入：tasks = [2,2,3,3,2,4,4,4,4,4]
 * 输出：4
 * 解释：要想完成所有任务，一个可能的计划是：
 * - 第一轮，完成难度级别为 2 的 3 个任务。
 * - 第二轮，完成难度级别为 3 的 2 个任务。
 * - 第三轮，完成难度级别为 4 的 3 个任务。
 * - 第四轮，完成难度级别为 4 的 2 个任务。
 * 可以证明，无法在少于 4 轮的情况下完成所有任务，所以答案为 4 。
 * <p>
 * 示例 2：
 * 输入：tasks = [2,3,3]
 * 输出：-1
 * 解释：难度级别为 2 的任务只有 1 个，但每一轮执行中，只能选择完成 2 个或者 3 个相同难度级别的任务。因此，无法完成所有任务，答案为 -1 。
 * <p>
 * 提示：
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 * <p>
 * https://leetcode-cn.com/problems/minimum-rounds-to-complete-all-tasks/
 */
public class Problem2244_minimumRoundsToCompleteAllTasks {

    // BF time: O(n) space: O(n)
    public static int minimumRounds(int[] tasks) {
        if (tasks == null || tasks.length < 2) {
            return -1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tasks) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (value == 1) {
                return -1;
            } else if (value % 3 == 0) {
                ans += value / 3;
            } else if (value % 3 == 1) {
                ans += (value - 4) / 3 + 2;
            } else if (value % 3 == 2) {
                ans += (value - 2) / 3 + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
        System.out.println("2 ?= " + minimumRounds(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println("20 ?= " + minimumRounds(new int[]{69, 65, 62, 64, 70, 68, 69, 67, 60, 65, 69, 62, 65, 65, 61, 66, 68, 61, 65, 63, 60, 66, 68, 66, 67, 65, 63, 65, 70, 69, 70, 62, 68, 70, 60, 68, 65, 61, 64, 65, 63, 62, 62, 62, 67, 62, 62, 61, 66, 69}));
        System.out.println("20 ?= " + minimumRounds(new int[]{66, 66, 63, 61, 63, 63, 64, 66, 66, 65, 66, 65, 61, 67, 68, 66, 62, 67, 61, 64, 66, 60, 69, 66, 65, 68, 63, 60, 67, 62, 68, 60, 66, 64, 60, 60, 60, 62, 66, 64, 63, 65, 60, 69, 63, 68, 68, 69, 68, 61}));
        System.out.println("38 ?= " + minimumRounds(new int[]{119, 115, 115, 119, 118, 113, 118, 120, 110, 113, 119, 115, 116, 118, 120, 117, 116, 111, 113, 119, 115, 113, 115, 111, 112, 119, 111, 111, 110, 112, 113, 120, 110, 111, 112, 111, 119, 112, 113, 112, 115, 116, 113, 114, 118, 119, 115, 114, 114, 112, 110, 117, 120, 110, 117, 116, 120, 118, 110, 120, 119, 113, 119, 120, 113, 110, 120, 114, 119, 115, 119, 117, 120, 116, 113, 113, 110, 118, 117, 116, 114, 114, 111, 116, 119, 112, 113, 116, 112, 116, 119, 112, 114, 114, 112, 118, 116, 113, 117, 116}));
    }
}
