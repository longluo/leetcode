package com.longluo.contest.weekly_contest_313;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/contest/weekly-contest-313/
 */

/**
 * 2427. 公因子的数目
 * <p>
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * <p>
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * <p>
 * 示例 1：
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * <p>
 * 示例 2：
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 * <p>
 * 提示：
 * 1 <= a, b <= 1000
 * <p>
 * https://leetcode.cn/problems/number-of-common-factors/
 */
public class Problem2427_numberOfCommonFactors {

    // HashSet time: O(n) space: O(n)
    public static int commonFactors(int a, int b) {
        Set<Integer> set = new HashSet<>();
        set.add(1);
        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                set.add(i);
            }
        }

        return set.size();
    }

    // Math time: O(n) space: O(1)
    public static int commonFactors_opt(int a, int b) {
        int ans = 1;

        for (int i = 2; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("4 ?= " + commonFactors(12, 6));
        System.out.println("2 ?= " + commonFactors(25, 30));

        System.out.println("2 ?= " + commonFactors_opt(25, 30));
    }
}
