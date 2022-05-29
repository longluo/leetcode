package com.longluo.contest.weekly_contest_294;

import java.util.Arrays;

/**
 * 2280. 表示一个折线图的最少线段数
 * <p>
 * 给你一个二维整数数组 stockPrices ，其中 stockPrices[i] = [dayi, pricei] 表示股票在 dayi 的价格为 pricei 。
 * 折线图 是一个二维平面上的若干个点组成的图，横坐标表示日期，纵坐标表示价格，折线图由相邻的点连接而成。比方说下图是一个例子：
 * <p>
 * 请你返回要表示一个折线图所需要的 最少线段数 。
 * <p>
 * 示例 1：
 * 输入：stockPrices = [[1,7],[2,6],[3,5],[4,4],[5,4],[6,3],[7,2],[8,1]]
 * 输出：3
 * 解释：
 * 上图为输入对应的图，横坐标表示日期，纵坐标表示价格。
 * 以下 3 个线段可以表示折线图：
 * - 线段 1 （红色）从 (1,7) 到 (4,4) ，经过 (1,7) ，(2,6) ，(3,5) 和 (4,4) 。
 * - 线段 2 （蓝色）从 (4,4) 到 (5,4) 。
 * - 线段 3 （绿色）从 (5,4) 到 (8,1) ，经过 (5,4) ，(6,3) ，(7,2) 和 (8,1) 。
 * 可以证明，无法用少于 3 条线段表示这个折线图。
 * <p>
 * 示例 2：
 * 输入：stockPrices = [[3,4],[1,2],[7,8],[2,3]]
 * 输出：1
 * 解释：
 * 如上图所示，折线图可以用一条线段表示。
 * <p>
 * 提示：
 * 1 <= stockPrices.length <= 10^5
 * stockPrices[i].length == 2
 * 1 <= dayi, pricei <= 10^9
 * 所有 dayi 互不相同 。
 * <p>
 * https://leetcode.cn/problems/minimum-lines-to-represent-a-line-chart/
 */
public class Problem2280_minimumLinesToRepresentALineChart {

    // Multiply time: O(nlogn) space: O(logn)
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

    // Slope GCD time: O(nlogn) space: O(logn)
    public static int minimumLines_slope(int[][] stockPrices) {
        int len = stockPrices.length;
        if (len <= 1) {
            return 0;
        }

        Arrays.sort(stockPrices, (o1, o2) -> o1[0] - o2[0]);

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
        System.out.println("13 ?= " + minimumLines_slope(new int[][]{{25, 19}, {91, 30}, {52, 73}, {99, 71}, {47, 22}, {19, 30}, {80, 63}, {18, 15}, {48, 17}, {77, 16}, {46, 27}, {66, 87}, {55, 84}, {65, 38}, {30, 9}}));
    }
}
