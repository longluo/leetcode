package com.longluo.leetcode.geometry;

/**
 * 1037. 有效的回旋镖
 * <p>
 * 给定一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点，如果这些点构成一个 回旋镖 则返回 true 。
 * <p>
 * 回旋镖 定义为一组三个点，这些点 各不相同 且 不在一条直线上 。
 * <p>
 * 示例 1：
 * 输入：points = [[1,1],[2,3],[3,2]]
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：false
 * <p>
 * 提示：
 * points.length == 3
 * points[i].length == 2
 * 0 <= xi, yi <= 100
 * <p>
 * https://leetcode.cn/problems/valid-boomerang/
 */
public class Problem1037_validBoomerang {

    // Line Slope time: O(1) space: O(1)
    public static boolean isBoomerang(int[][] points) {
        int[] AB = {points[1][0] - points[0][0], points[1][1] - points[0][1]};
        int[] AC = {points[2][0] - points[0][0], points[2][1] - points[0][1]};

        return AB[0] * AC[1] != AB[1] * AC[0];
    }

    public static void main(String[] args) {
        System.out.println("true ?= " + isBoomerang(new int[][]{{1, 1}, {2, 3}, {3, 2}}));
        System.out.println("false ?= " + isBoomerang(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
