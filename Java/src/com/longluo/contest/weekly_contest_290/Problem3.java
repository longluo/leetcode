package com.longluo.contest.weekly_contest_290;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/count-number-of-rectangles-containing-each-point/
 */
public class Problem3 {

    // TLE
    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int rectCnt = rectangles.length;

        int len = points.length;

        Arrays.sort(rectangles, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int cnt = 0;

            for (int j = rectCnt - 1; j >= 0; j--) {
                int l = rectangles[j][0];
                int h = rectangles[j][1];

                if (x > l && y > h) {
                    continue;
                }

                if (x <= l && y <= h) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    //
    public static int[] countRectangles_opt(int[][] rectangles, int[][] points) {
        int rectCnt = rectangles.length;

        int len = points.length;

        Arrays.sort(rectangles, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[] ans = new int[len];

        for (int i = 0; i < len; i++) {
            int x = points[i][0];
            int y = points[i][1];

            int cnt = 0;

            for (int j = rectCnt - 1; j >= 0; j--) {
                int l = rectangles[j][0];
                int h = rectangles[j][1];

                if (x > l && y > h) {
                    continue;
                }

                if (x <= l && y <= h) {
                    cnt++;
                }
            }

            ans[i] = cnt;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("[2, 1] ?= " + Arrays.toString(countRectangles(new int[][]{{1, 2}, {2, 3}, {2, 5}}, new int[][]{{2, 1}, {1, 4}})));
        System.out.println("[1, 3] ?= " + Arrays.toString(countRectangles(new int[][]{{1, 1}, {2, 2}, {3, 3}}, new int[][]{{1, 3}, {1, 1}})));
        System.out.println("[1, 3] ?= " + Arrays.toString(countRectangles_opt(new int[][]{{1, 1}, {2, 2}, {3, 3}}, new int[][]{{1, 3}, {1, 1}})));
    }
}
