package com.longluo.offer;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子2、3和5的数称作丑数（Ugly Number）。求按从小到大的顺序的第n个丑数。
 * <p>
 * 示例:
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12是前10个丑数。
 * <p>
 * 说明:
 * 1是丑数。
 * n不超过1690。
 */
public class Offer49_nthUglyNumber {

    public static int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int a = 0;
        int b = 0;
        int c = 0;
        for (int i = 1; i < n; i++) {
            int n2 = dp[a] * 2;
            int n3 = dp[b] * 3;
            int n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if (dp[i] == n2) {
                a++;
            }
            if (dp[i] == n3) {
                b++;
            }
            if (dp[i] == n5) {
                c++;
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + nthUglyNumber(1));
        System.out.println("2 ?= " + nthUglyNumber(2));
        System.out.println("12 ?= " + nthUglyNumber(10));
    }
}
