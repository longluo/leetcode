package com.longluo.leetcode.dp;

import java.util.Arrays;

/**
 * 1220. 统计元音字母序列的数目
 * <p>
 * 给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：
 * <p>
 * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
 * 每个元音 'a' 后面都只能跟着 'e'
 * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
 * 每个元音 'i' 后面 不能 再跟着另一个 'i'
 * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
 * 每个元音 'u' 后面只能跟着 'a'
 * 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
 * <p>
 * 示例 2：
 * 输入：n = 2
 * 输出：10
 * 解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
 * <p>
 * 示例 3：
 * 输入：n = 5
 * 输出：68
 * <p>
 * 提示：
 * 1 <= n <= 2 * 10^4
 * <p>
 * https://leetcode.com/problems/count-vowels-permutation/
 */
public class Problem1220_countVowelPermutation {

    // DP
    public static int countVowelPermutation(int n) {
        long mod = 1_000_000_007;

        long[] dp = new long[5];
        long[] ndp = new long[5];

        for (int i = 0; i < 5; ++i) {
            dp[i] = 1;
        }

        for (int i = 2; i <= n; ++i) {
            /* a前面可以为e,u,i */
            ndp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            /* e前面可以为a,i */
            ndp[1] = (dp[0] + dp[2]) % mod;
            /* i前面可以为e,o */
            ndp[2] = (dp[1] + dp[3]) % mod;
            /* o前面可以为i */
            ndp[3] = dp[2];
            /* u前面可以为i,o */
            ndp[4] = (dp[2] + dp[3]) % mod;
            System.arraycopy(ndp, 0, dp, 0, 5);
        }

        long ans = 0;
        for (int i = 0; i < 5; ++i) {
            ans = (ans + dp[i]) % mod;
        }

        return (int) ans;
    }

    // DP time: O(n) space: O(n)
    public static int countVowelPermutation_dp(int n) {
        long mod = 1_000_000_007;

        int[][] dp = new int[n][5];
        Arrays.fill(dp[0], 1);

        for (int i = 0; i < n - 1; i++) {
            dp[i + 1][1] += dp[i][0];

            dp[i + 1][0] += dp[i][1];
            dp[i + 1][2] += dp[i][1];

            dp[i + 1][0] += dp[i][2];
            dp[i + 1][1] += dp[i][2];
            dp[i + 1][3] += dp[i][2];
            dp[i + 1][4] += dp[i][2];

            dp[i + 1][2] += dp[i][3];
            dp[i + 1][4] += dp[i][3];

            dp[i + 1][0] += dp[i][4];

            for (int j = 0; j < 5; j++) {
                dp[i + 1][j] %= mod;
            }
        }

        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans += dp[n - 1][i];
        }

        return (int) (ans % mod);
    }

    public static void main(String[] args) {
        System.out.println("5 ?= " + countVowelPermutation(1));
        System.out.println("10 ?= " + countVowelPermutation(2));
        System.out.println("68 ?= " + countVowelPermutation(5));

        System.out.println("68 ?= " + countVowelPermutation_dp(5));
    }
}
