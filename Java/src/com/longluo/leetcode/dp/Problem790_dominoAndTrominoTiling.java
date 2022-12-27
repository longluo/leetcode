package com.longluo.leetcode.dp;

/**
 * 790. 多米诺和托米诺平铺
 * <p>
 * 有两种形状的瓷砖：一种是 2 x 1 的多米诺形，另一种是形如 "L" 的托米诺形。两种形状都可以旋转。
 * <p>
 * 给定整数 n ，返回可以平铺 2 x n 的面板的方法的数量。返回对 10^9 + 7 取模 的值。
 * <p>
 * 平铺指的是每个正方形都必须有瓷砖覆盖。两个平铺不同，当且仅当面板上有四个方向上的相邻单元中的两个，
 * 使得恰好有一个平铺有一个瓷砖占据两个正方形。
 * <p>
 * 示例 1:
 * 输入: n = 3
 * 输出: 5
 * 解释: 五种不同的方法如上所示。
 * <p>
 * 示例 2:
 * 输入: n = 1
 * 输出: 1
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * <p>
 * https://leetcode.cn/problems/domino-and-tromino-tiling/
 */
public class Problem790_dominoAndTrominoTiling {

    // DP time: O(n) space: O(n)
    public static int numTilings(int n) {
        int mod = 1_000_000_007;

        long[][] dp = new long[n + 1][4];

        dp[0][3] = 1;

        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3] % mod;

            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][1] = dp[i][1] % mod;

            dp[i][2] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][2] = dp[i][2] % mod;

            dp[i][3] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3];
            dp[i][3] = dp[i][3] % mod;
        }

        return (int) (dp[n][3] % mod);
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + numTilings(1));
        System.out.println("2 ?= " + numTilings(2));
        System.out.println("5 ?= " + numTilings(3));
        System.out.println("11 ?= " + numTilings(4));
        System.out.println("24 ?= " + numTilings(5));
    }
}
