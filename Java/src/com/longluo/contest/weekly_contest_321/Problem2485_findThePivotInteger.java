package com.longluo.contest.weekly_contest_321;

/**
 * https://leetcode.cn/contest/weekly-contest-321
 */

/**
 * 2485. 找出中枢整数
 * <p>
 * 给你一个正整数 n ，找出满足下述条件的 中枢整数 x ：
 * <p>
 * 1 和 x 之间的所有元素之和等于 x 和 n 之间所有元素之和。
 * <p>
 * 返回中枢整数 x 。如果不存在中枢整数，则返回 -1 。题目保证对于给定的输入，至多存在一个中枢整数。
 * <p>
 * 示例 1：
 * 输入：n = 8
 * 输出：6
 * 解释：6 是中枢整数，因为 1 + 2 + 3 + 4 + 5 + 6 = 6 + 7 + 8 = 21 。
 * <p>
 * 示例 2：
 * 输入：n = 1
 * 输出：1
 * 解释：1 是中枢整数，因为 1 = 1 。
 * <p>
 * 示例 3：
 * 输入：n = 4
 * 输出：-1
 * 解释：可以证明不存在满足题目要求的整数。
 * <p>
 * 提示：
 * 1 <= n <= 1000
 * <p>
 * https://leetcode.cn/problems/find-the-pivot-integer/
 */
public class Problem2485_findThePivotInteger {

    // Math time: O(n) space: O(1)
    public static int pivotInteger(int n) {
        int total = n * (n + 1) / 2;

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;

            if ((total + i) % 2 == 0 && (total + i) / 2 == sum) {
                return i;
            }
        }

        return -1;
    }

    // Math time: O(1) space: O(1)
    public static int pivotInteger_fast(int n) {
        int total = n * (n + 1) / 2;

        double sqrt = Math.sqrt(total);

        int x = (int) sqrt;

        return sqrt == x ? x : -1;
    }

    public static void main(String[] args) {
        System.out.println("1 ?= " + pivotInteger(1));
        System.out.println("-1 ?= " + pivotInteger(4));
        System.out.println("6 ?= " + pivotInteger(8));

        System.out.println("-1 ?= " + pivotInteger_fast(4));
        System.out.println("6 ?= " + pivotInteger_fast(8));
    }
}
