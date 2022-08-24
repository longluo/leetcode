package com.longluo.contest.weekly_contest_306;

/**
 * 2376. 统计特殊整数
 * <p>
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 * <p>
 * 示例 1：
 * 输入：n = 20
 * 输出：19
 * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 * <p>
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * 解释：1 到 5 所有整数都是特殊整数。
 * <p>
 * 示例 3：
 * 输入：n = 135
 * 输出：110
 * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
 * 不特殊的部分数字为：22 ，114 和 131 。
 * <p>
 * 提示：
 * 1 <= n <= 2 * 10^9
 * <p>
 * https://leetcode.cn/problems/count-special-integers/
 */
public class Problem2376_countSpecialIntegers {

    // TODO: 2022/8/24  
    public static int countSpecialNumbers(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("19 ?= " + countSpecialNumbers(20));
    }
}
