package com.longluo.leetcode.math;

/**
 * 1688. 比赛中的配对次数
 * <p>
 * 给你一个整数 n ，表示比赛中的队伍数。比赛遵循一种独特的赛制：
 * <p>
 * 如果当前队伍数是 偶数 ，那么每支队伍都会与另一支队伍配对。总共进行 n / 2 场比赛，且产生 n / 2 支队伍进入下一轮。
 * 如果当前队伍数为 奇数 ，那么将会随机轮空并晋级一支队伍，其余的队伍配对。总共进行 (n - 1) / 2 场比赛，
 * 且产生 (n - 1) / 2 + 1 支队伍进入下一轮。
 * 返回在比赛中进行的配对次数，直到决出获胜队伍为止。
 * <p>
 * 示例 1：
 * 输入：n = 7
 * 输出：6
 * 解释：比赛详情：
 * - 第 1 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * - 第 2 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * - 第 3 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * 总配对次数 = 3 + 2 + 1 = 6
 * <p>
 * 示例 2：
 * 输入：n = 14
 * 输出：13
 * 解释：比赛详情：
 * - 第 1 轮：队伍数 = 14 ，配对次数 = 7 ，7 支队伍晋级。
 * - 第 2 轮：队伍数 = 7 ，配对次数 = 3 ，4 支队伍晋级。
 * - 第 3 轮：队伍数 = 4 ，配对次数 = 2 ，2 支队伍晋级。
 * - 第 4 轮：队伍数 = 2 ，配对次数 = 1 ，决出 1 支获胜队伍。
 * 总配对次数 = 7 + 3 + 2 + 1 = 13
 * <p>
 * 提示：
 * 1 <= n <= 200
 * <p>
 * https://leetcode-cn.com/problems/count-of-matches-in-tournament/
 */
public class Problem1688_numberOfMatches {

    public static int numberOfMatches(int n) {
        if (n <= 1) {
            return 0;
        }

        int ans = 0;
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
                ans += n;
            } else {
                ans += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }

        return ans;
    }

    public static int numberOfMatches_dp(int n) {
        if (n <= 1) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            if (i % 2 == 0) {
                dp[i] = i / 2 + dp[i / 2];
            } else {
                dp[i] = (i - 1) / 2 + dp[(i - 1) / 2 + 1];
            }
        }

        return dp[n];
    }

    public static int numberOfMatches_math(int n) {
        return n - 1;
    }

    public static void main(String[] args) {
        System.out.println("6 ?= " + numberOfMatches(7));
        System.out.println("13 ?= " + numberOfMatches(14));

        System.out.println("0 ?= " + numberOfMatches_dp(1));
        System.out.println("6 ?= " + numberOfMatches_dp(7));
        System.out.println("13 ?= " + numberOfMatches_dp(14));

        System.out.println("0 ?= " + numberOfMatches_math(1));
        System.out.println("6 ?= " + numberOfMatches_math(7));
        System.out.println("13 ?= " + numberOfMatches_math(14));
    }
}
