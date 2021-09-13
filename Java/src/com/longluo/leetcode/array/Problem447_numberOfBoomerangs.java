package com.longluo.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 447. 回旋镖的数量
 * <p>
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，
 * 其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 返回平面上所有回旋镖的数量。
 * <p>
 * 示例 1：
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * <p>
 * 示例 3：
 * 输入：points = [[1,1]]
 * 输出：0
 * <p>
 * 提示：
 * n == points.length
 * 1 <= n <= 500
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * 所有点都 互不相同
 * <p>
 * https://leetcode-cn.com/problems/number-of-boomerangs/
 */
public class Problem447_numberOfBoomerangs {

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length < 3) {
            return 0;
        }

        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int distance = getDistance(points[i], points[j]);
                countMap.put(distance, countMap.getOrDefault(distance, 0) + 1);
            }

            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int m = entry.getValue();
                ans += m * (m - 1);
            }
        }

        return ans;
    }

    public static int getDistance(int[] pointX, int[] pointY) {
        int x1 = pointX[0];
        int y1 = pointX[1];
        int x2 = pointY[0];
        int y2 = pointY[1];

        int deltaX = x2 - x1;
        int deltaY = y2 - y1;

        return deltaX * deltaX + deltaY * deltaY;
    }

    public static void main(String[] args) {
        System.out.println("0 ?= " + numberOfBoomerangs(new int[][]{{1, 1}}));
        System.out.println("0 ?= " + numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}}));
        System.out.println("2 ?= " + numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
        System.out.println("2 ?= " + numberOfBoomerangs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
    }
}
