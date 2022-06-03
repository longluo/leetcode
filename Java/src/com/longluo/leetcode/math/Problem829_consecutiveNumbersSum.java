package com.longluo.leetcode.math;

/**
 * 829. 连续整数求和
 * <p>
 * 给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。
 * <p>
 * 示例 1:
 * 输入: n = 5
 * 输出: 2
 * 解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。
 * <p>
 * 示例 2:
 * 输入: n = 9
 * 输出: 3
 * 解释: 9 = 4 + 5 = 2 + 3 + 4
 * <p>
 * 示例 3:
 * 输入: n = 15
 * 输出: 4
 * 解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5
 * <p>
 * 提示:
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/consecutive-numbers-sum/
 */
public class Problem829_consecutiveNumbersSum {

    // BF time: O(n^2) space: O(1)
    // TLE
    public static int consecutiveNumbersSum_bf(int n) {
        int ans = 1;
        for (int i = 1; i <= n / 2; i++) {
            int sum = i;
            for (int j = i + 1; j < n; j++) {
                sum += j;
                if (sum == n) {
                    ans++;
                    break;
                } else if (sum > n) {
                    break;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("2 ?= " + consecutiveNumbersSum_bf(5));
        System.out.println("3 ?= " + consecutiveNumbersSum_bf(9));
        System.out.println("4 ?= " + consecutiveNumbersSum_bf(15));
    }
}
