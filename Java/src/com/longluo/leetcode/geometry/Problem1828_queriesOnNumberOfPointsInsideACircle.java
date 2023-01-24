package com.longluo.leetcode.geometry;

import java.util.Arrays;

/**
 * 1828. 统计一个圆中点的数目
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] ，表示第 i 个点在二维平面上的坐标。多个点可能会有 相同 的坐标。
 * <p>
 * 同时给你一个数组 queries ，其中 queries[j] = [xj, yj, rj] ，表示一个圆心在 (xj, yj) 且半径为 rj 的圆。
 * <p>
 * 对于每一个查询 queries[j] ，计算在第 j 个圆 内 点的数目。如果一个点在圆的 边界上 ，我们同样认为它在圆 内 。
 * <p>
 * 请你返回一个数组 answer ，其中 answer[j]是第 j 个查询的答案。
 * <p>
 * 示例 1：
 * 输入：points = [[1,3}, {3,3}, {5,3}, {2,2]], queries = [[2,3,1}, {4,3,1}, {1,1,2]]
 * 输出：[3,2,2]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆。
 * <p>
 * 示例 2：
 * 输入：points = [[1,1}, {2,2}, {3,3}, {4,4}, {5,5]], queries = [[1,2,2}, {2,2,2}, {4,3,2}, {4,3,3]]
 * 输出：[2,3,2,4]
 * 解释：所有的点和圆如上图所示。
 * queries[0] 是绿色的圆，queries[1] 是红色的圆，queries[2] 是蓝色的圆，queries[3] 是紫色的圆。
 * <p>
 * 提示：
 * 1 <= points.length <= 500
 * points[i].length == 2
 * 0 <= xi, yi <= 500
 * 1 <= queries.length <= 500
 * queries[j].length == 3
 * 0 <= xj, yj <= 500
 * 1 <= rj <= 500
 * 所有的坐标都是整数。
 * <p>
 * https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/
 */
public class Problem1828_queriesOnNumberOfPointsInsideACircle {

    // BF time: O(mn) space: O(1)
    public static int[] countPoints(int[][] points, int[][] queries) {
        int len = queries.length;

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int cnt = 0;

            int[] circle = queries[i];

            for (int[] pt : points) {
                int dist = (pt[0] - circle[0]) * (pt[0] - circle[0]) + (pt[1] - circle[1]) * (pt[1] - circle[1]);
                if (dist <= circle[2] * circle[2]) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[3, 2, 2] ?= " + Arrays.toString(countPoints(new int[][]{{1, 3}, {3, 3}, {5, 3}, {2, 2}}, new int[][]{{2, 3, 1}, {4, 3, 1}, {1, 1, 2}})));
        System.out.println("[2, 3, 2, 4] ?= " + Arrays.toString(countPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}}, new int[][]{{1, 2, 2}, {2, 2, 2}, {4, 3, 2}, {4, 3, 3}})));
    }
}
