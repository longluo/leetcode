package com.longluo.leetcode.dp;

/**
 * 1269. 停在原地的方案数
 * <p>
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 * 给你两个整数steps和arrLen，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 * <p>
 * 示例 1：
 * 输入：steps = 3, arrLen = 2
 * 输出：4
 * 解释：3 步后，总共有 4 种不同的方法可以停在索引 0 处。
 * 向右，向左，不动
 * 不动，向右，向左
 * 向右，不动，向左
 * 不动，不动，不动
 * <p>
 * 示例  2：
 * 输入：steps = 2, arrLen = 4
 * 输出：2
 * 解释：2 步后，总共有 2 种不同的方法可以停在索引 0 处。
 * 向右，向左
 * 不动，不动
 * <p>
 * 示例 3：
 * 输入：steps = 4, arrLen = 2
 * 输出：8
 * <p>
 * 提示：
 * 1 <= steps <= 500
 * 1 <= arrLen <= 10^6
 * <p>
 * https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 */
public class Problem1269_numberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    public static int numWays(int steps, int arrLen) {
        if (steps <= 1 || arrLen <= 1) {
            return 1;
        }

        final int modulo = 1000000007;
        int maxColumn = Math.min(steps, arrLen - 1);
        int[][] dp = new int[steps + 1][maxColumn + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= steps; i++) {
            for (int j = 0; j <= maxColumn; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % modulo;
                }
                if (j + 1 <= maxColumn) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % modulo;
                }
            }
        }

        return dp[steps][0];
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + numWays(3, 2));
        System.out.println("2 ?= " + numWays(2, 4));
        System.out.println("8 ?= " + numWays(4, 2));
    }
}
