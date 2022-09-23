package com.longluo.leetcode.bitmanipulation;

/**
 * 1680. 连接连续二进制数字
 * <p>
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 10^9 + 7 取余的结果。
 * <p>
 * 示例 1：
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * <p>
 * 示例 2：
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * <p>
 * 示例 3：
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 10^9 + 7 取余后，结果为 505379714 。
 * <p>
 * 提示：
 * 1 <= n <= 10^5
 * <p>
 * https://leetcode.cn/problems/concatenation-of-consecutive-binary-numbers/
 */
public class Problem1680_concatenationOfConsecutiveBinaryNumbers {

    // Use API time: O(n) space: O(n)
    public static int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            int leftshift = Integer.toBinaryString(i).length();

            for (int j = 0; j < leftshift; j++) {
                ans = ans << 1;
                ans = ans % MOD;
            }

            ans += i;
            ans %= MOD;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + concatenatedBinary(1));
        System.out.println("27 ?= " + concatenatedBinary(3));
        System.out.println("220 ?= " + concatenatedBinary(7));
        System.out.println("505379714 ?= " + concatenatedBinary(12));

        System.out.println(Integer.parseInt("11011100", 2));
        System.out.println(Integer.parseInt("11011100101", 2));
        System.out.println(Integer.parseInt("11011100101110", 2));
        System.out.println(Integer.parseInt("11011100101110111", 2));
    }
}
