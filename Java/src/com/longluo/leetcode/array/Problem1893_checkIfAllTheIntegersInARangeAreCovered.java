package com.longluo.leetcode.array;

/**
 * 1893. 检查是否区域内所有整数都被覆盖
 * <p>
 * 给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi]表示一个从starti到endi的 闭区间 。
 * 如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
 * 已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
 * <p>
 * 示例 1：
 * 输入：ranges = [[1,2],[3,4],[5,6]], left = 2, right = 5
 * 输出：true
 * 解释：2 到 5 的每个整数都被覆盖了：
 * - 2 被第一个区间覆盖。
 * - 3 和 4 被第二个区间覆盖。
 * - 5 被第三个区间覆盖。
 * <p>
 * 示例 2：
 * 输入：ranges = [[1,10],[10,20]], left = 21, right = 21
 * 输出：false
 * 解释：21 没有被任何一个区间覆盖。
 * <p>
 * 提示：
 * 1 <= ranges.length <= 50
 * 1 <= starti <= endi <= 50
 * 1 <= left <= right <= 50
 * <p>
 * https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 */
public class Problem1893_checkIfAllTheIntegersInARangeAreCovered {

    public static boolean isCovered(int[][] ranges, int left, int right) {
        int length = ranges.length;
        for (int i = left; i <= right; i++) {
            boolean isContain = false;
            for (int j = 0; j < length; j++) {
                if (ranges[j][0] <= i && ranges[j][1] >= i) {
                    isContain = true;
                }
            }
            if (!isContain) {
                return false;
            }
        }

        return true;
    }

    public static boolean isCovered_2(int[][] ranges, int left, int right) {
        return false;
    }

    public static void main(String[] args) {
        System.out.println("false ?= " + isCovered(new int[][]{{1, 10}, {10, 20}}, 21, 21));
        System.out.println("true ?= " + isCovered(new int[][]{{1, 2}, {3, 4}, {5, 6}}, 2, 5));
    }
}
