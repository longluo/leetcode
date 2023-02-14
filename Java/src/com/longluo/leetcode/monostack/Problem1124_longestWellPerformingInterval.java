package com.longluo.leetcode.monostack;

/**
 * 1124. 表现良好的最长时间段
 * <p>
 * 给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。
 * 我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。
 * 所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。
 * 请你返回「表现良好时间段」的最大长度。
 * <p>
 * 示例 1：
 * 输入：hours = [9,9,6,0,6,6,9]
 * 输出：3
 * 解释：最长的表现良好时间段是 [9,9,6]。
 * <p>
 * 示例 2：
 * 输入：hours = [6,6,6]
 * 输出：0
 * <p>
 * 提示：
 * 1 <= hours.length <= 10^4
 * 0 <= hours[i] <= 16
 * <p>
 * https://leetcode.cn/problems/longest-well-performing-interval/
 */
public class Problem1124_longestWellPerformingInterval {

    // BF time: O(n^2) space: O(1)
    // AC 2023年2月14日
    public static int longestWPI_bf(int[] hours) {
        int ans = 0;

        int n = hours.length;

        for (int i = 0; i < n; i++) {
            int tired = 0;
            for (int j = i; j < n; j++) {
                tired += hours[j] > 8 ? 1 : 0;
                int days = j - i + 1;
                if (days < 2 * tired) {
                    ans = Math.max(ans, days);
                }
            }
        }

        return ans;
    }

    //
    public static int longestWPI(int[] hours) {
        int ans = 0;

        int n = hours.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, j - i + 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + longestWPI_bf(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println("0 ?= " + longestWPI_bf(new int[]{6, 6, 6}));

        System.out.println("3 ?= " + longestWPI(new int[]{9, 9, 6, 0, 6, 6, 9}));
        System.out.println("0 ?= " + longestWPI(new int[]{6, 6, 6}));
    }
}
