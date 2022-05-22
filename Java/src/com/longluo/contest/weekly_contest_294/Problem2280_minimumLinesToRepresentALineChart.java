package com.longluo.contest.weekly_contest_294;

import java.util.Arrays;

public class Problem2280_minimumLinesToRepresentALineChart {

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

    public static void main(String[] args) {
        System.out.println("1 ?= " + minimumLines(new int[][]{{3, 4}, {1, 2}, {7, 8}, {2, 3}}));
        System.out.println("3 ?= " + minimumLines(new int[][]{{1, 7}, {2, 6}, {3, 5}, {4, 4}, {5, 4}, {6, 3}, {7, 2}, {8, 1}}));
    }
}
