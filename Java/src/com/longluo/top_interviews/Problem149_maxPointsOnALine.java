package com.longluo.top_interviews;

/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1：
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出：4
 * <p>
 * 提示：
 * 1 <= points.length <= 300
 * points[i].length == 2
 * -10^4 <= xi, yi <= 10^4
 * points 中的所有点 互不相同
 * <p>
 * https://leetcode.com/problems/max-points-on-a-line/
 */
public class Problem149_maxPointsOnALine {

    // Brute Force time: O(n^3) space: O(1)
    public static int maxPoints_bf(int[][] points) {
        int len = points.length;
        if (len <= 2) {
            return len;
        }

        int max = 2;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++)  {
                int deltaX = points[j][0] - points[i][0];
                int deltaY = points[j][1] - points[i][1];
                int count = 2;

                for (int k = 0; k < len; k++) {
                    if (k == i || k == j) {
                        continue;
                    }

                    int diffX = points[k][0] - points[j][0];
                    int diffY = points[k][1] - points[j][1];

                    if (diffX * deltaY == diffY * deltaX) {
                        count++;
                    }
                }

                max = Math.max(max, count);
                if (max == len) {
                    break;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxPoints_bf(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println("3 ?= " + maxPoints_bf(new int[][]{{3, 3}, {1, 4}, {1, 1}, {2, 1}, {2, 2}}));
        System.out.println("4 ?= " + maxPoints_bf(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        System.out.println("3 ?= " + maxPoints_bf(new int[][]{{4, 5}, {4, -1}, {4, 0}}));
        System.out.println("3 ?= " + maxPoints_bf(new int[][]{{-6, -1}, {3, 1}, {12, 3}}));
        System.out.println("3 ?= " + maxPoints_bf(new int[][]{{-6, -1}, {3, 1}, {12, 3}}));
    }
}
