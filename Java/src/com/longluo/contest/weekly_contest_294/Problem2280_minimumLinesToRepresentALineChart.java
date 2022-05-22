package com.longluo.contest.weekly_contest_294;

import java.util.Arrays;

public class Problem2280_minimumLinesToRepresentALineChart {

    // Slope time: O(nlogn) space: O(logn)
    public static int minimumLines(int[][] stockPrices) {
        int len = stockPrices.length;
        if (len <= 2) {
            return len - 1;
        }

        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);

        int ans = 1;
        for (int i = 2; i < len; i++) {
            int y = stockPrices[i][1] - stockPrices[i - 1][1];
            int x = stockPrices[i][0] - stockPrices[i - 1][0];
            int y1 = stockPrices[i - 1][1] - stockPrices[i - 2][1];
            int x1 = stockPrices[i - 1][0] - stockPrices[i - 2][0];
            if (y * x1 != y1 * x) {
                ans++;
            }
        }

        return ans;
    }

    // TODO: 2022/5/22 some bugs 
    public static int minimumLines_slope(int[][] stockPrices) {
        int len = stockPrices.length;
        if (len <= 1) {
            return 0;
        }

        int ans = 0;
        int[] preSlope = {0, 1};
        for (int i = 1; i < len; i++) {
            int[] curSlope = getSlope(stockPrices[i - 1], stockPrices[i]);
            if (!(curSlope[0] == preSlope[0] && curSlope[1] == preSlope[1])) {
                ans++;
                preSlope = curSlope;
            }
        }

        return ans;
    }

    public static int[] getSlope(int[] point1, int[] point2) {
        int dy = point2[1] - point1[1];
        int dx = point2[0] - point1[0];
        int g = gcd(dx, dy);
        return new int[]{dx / g, dy / g};
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println("3 ?= " + minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));

        System.out.println("1 ?= " + minimumLines_slope(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println("3 ?= " + minimumLines_slope(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
    }
}
