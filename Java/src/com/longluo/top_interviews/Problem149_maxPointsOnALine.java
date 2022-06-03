package com.longluo.top_interviews;

/**
 * 149. 直线上最多的点数
 * <p>
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 * <p>
 * 示例 1：
 * 输入：points = [[1,1}, {2,2}, {3,3]]
 * 输出：3
 * <p>
 * 示例 2：
 * 输入：points = [[1,1}, {3,2}, {5,3}, {4,1}, {2,3}, {1,4]]
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

    public static int maxPoints(int[][] points) {
        if (points == null || points.length == 0 || points[0].length == 0) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }

        int ans = 2;
        int n = points.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i != j) {
                    float k = 0;
                    float a = 0;
                    if (points[i][0] != points[j][0] && points[i][1] == points[j][1]) {
                        k = 0;
                        a = points[i][1];
                    } else if (points[i][0] == points[j][0] && points[i][1] != points[j][1]) {
                        k = Float.MAX_VALUE;
                        a = 0;
                    } else {
                        k = (points[j][1] - points[i][1]) / (points[j][0] - points[i][0]);
                        a = points[i][1] - k * points[i][0];
                    }
                    if ((int) a != a) {
                        continue;
                    } else {
                        int count = 2;
                        for (int m = 0; m < n; m++) {
                            if (m != i && m != j) {
                                if (k == 0) {
                                    if (points[m][1] == points[i][1]) {
                                        count++;
                                    }
                                } else if (k == Float.MAX_VALUE) {
                                    if (points[m][0] == points[i][0]) {
                                        count++;
                                    }
                                } else {
                                    if (k * points[m][0] + a == points[m][1]) {
                                        count++;
                                    }
                                }

                                if (count == n) {
                                    return n;
                                }
                            }
                        }
                        ans = Math.max(ans, count);
                    }
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println("4 ?= " + maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
        System.out.println("3 ?= " + maxPoints(new int[][]{{4, 5}, {4, -1}, {4, 0}}));
        System.out.println("3 ?= " + maxPoints(new int[][]{{-6, -1}, {3, 1}, {12, 3}}));
    }
}
