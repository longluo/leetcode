package com.longluo.leetcode.sorting;

import java.util.Arrays;

/**
 * 1051. 高度检查器
 * <p>
 * 学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
 * <p>
 * 排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）。
 * <p>
 * 给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
 * <p>
 * 返回满足 heights[i] != expected[i] 的 下标数量 。
 * <p>
 * 示例：
 * 输入：heights = [1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度：[1,1,4,2,1,3]
 * 预期：[1,1,1,2,3,4]
 * 下标 2 、4 、5 处的学生高度不匹配。
 * <p>
 * 示例 2：
 * 输入：heights = [5,1,2,3,4]
 * 输出：5
 * 解释：
 * 高度：[5,1,2,3,4]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都不匹配。
 * <p>
 * 示例 3：
 * 输入：heights = [1,2,3,4,5]
 * 输出：0
 * 解释：
 * 高度：[1,2,3,4,5]
 * 预期：[1,2,3,4,5]
 * 所有下标的对应学生高度都匹配。
 * <p>
 * 提示：
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * https://leetcode.cn/problems/height-checker/
 */
public class Problem1051_heightChecker {

    // Sorting time: O(nlogn) space: O(n)
    public static int heightChecker_sort(int[] heights) {
        int[] expected = heights.clone();
        int ans = 0;
        Arrays.sort(expected);
        for (int i = 0; i < heights.length; i++) {
            if (expected[i] != heights[i]) {
                ans++;
            }
        }

        return ans;
    }

    // Count Sort time: O(n + C) space: O(C)
    public static int heightChecker(int[] heights) {
        int[] counts = new int[101];
        for (int x : heights) {
            counts[x]++;
        }

        int ans = 0;
        for (int i = 0, h = 1; i < heights.length; i++) {
            while (counts[h] == 0) {
                h++;
            }

            if (counts[h] > 0) {
                if (heights[i] != h) {
                    ans++;
                }

                counts[h]--;
            }
        }

        return ans;
    }

    // Count Sort Opt time: O(C) space: O(C)
    public static int heightChecker_opt(int[] heights) {
        int[] counts = new int[101];
        for (int x : heights) {
            counts[x]++;
        }

        int ans = 0;
        for (int h = 1, i = 0; h < counts.length; h++) {
            while (counts[h]-- > 0) {
                if (heights[i++] != h) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + heightChecker_sort(new int[]{1, 1, 4, 2, 1, 3}));

        System.out.println("3 ?= " + heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
        System.out.println("4 ?= " + heightChecker(new int[]{2, 1, 2, 1, 1, 2, 2, 1}));

        System.out.println("4 ?= " + heightChecker_opt(new int[]{2, 1, 2, 1, 1, 2, 2, 1}));
    }
}
