package com.longluo.offer_ii;

/**
 * 剑指 Offer II 091. 粉刷房子
 * <p>
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * 示例 1：
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 * <p>
 * 示例 2：
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 * <p>
 * 提示:
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 * <p>
 * https://leetcode.cn/problems/JEj789/
 */
public class Offer2_091_paintHouse {

    // DP time: O(n) space: O(n)
    public static int minCost(int[][] costs) {
        int len = costs.length;
        int[][] dp = new int[len][3];




        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            min = Math.min(min, dp[len - 1][i]);
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + minCost(new int[][]{{7, 6, 2}}));
    }
}
