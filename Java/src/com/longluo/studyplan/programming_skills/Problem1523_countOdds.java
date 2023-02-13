package com.longluo.studyplan.programming_skills;

/**
 * 1523. 在区间范围内统计奇数数目
 * <p>
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * <p>
 * 示例 2：
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * 提示：
 * 0 <= low <= high <= 10^9
 * <p>
 * https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/
 */
public class Problem1523_countOdds {

    // BF time: O(n) space: O(1)
    // TimeOut
    public static int countOdds_bf(int low, int high) {
        int ans = 0;

        for (int i = low; i <= high; i++) {
            if (i % 2 == 1) {
                ans++;
            }
        }

        return ans;
    }

    // BF Optimize time: O(n / 2) space: O(1)
    public static int countOdds_bf_opt(int low, int high) {
        int ans = 0;

        if (low % 2 == 0) {
            low++;
        }

        for (int i = low; i <= high; i += 2) {
            ans++;
        }

        return ans;
    }

    // Math time: O(1) space: O(1)
    public static int countOdds_math(int low, int high) {
        if (low % 2 == 0) {
            low++;
        }

        if (high % 2 == 0) {
            high--;
        }

        return (high - low) / 2 + 1;
    }

    // Math time: O(1) space: O(1)
    public static int countOdds(int low, int high) {
        return (high + 1) / 2 - low /2;
    }

    public static void main(String[] args) {
        System.out.println("3 ?= " + countOdds_bf(3, 7));
        System.out.println("1 ?= " + countOdds_bf(8, 10));

        System.out.println("3 ?= " + countOdds_bf_opt(3, 7));
        System.out.println("1 ?= " + countOdds_bf_opt(8, 10));

        System.out.println("3 ?= " + countOdds_math(3, 7));
        System.out.println("1 ?= " + countOdds_math(8, 10));

        System.out.println("3 ?= " + countOdds(3, 7));
        System.out.println("1 ?= " + countOdds(8, 10));
    }
}
