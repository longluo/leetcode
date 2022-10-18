package com.longluo.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 902. 最大为 N 的数字组合
 * <p>
 * 给定一个按 非递减顺序 排列的数字数组 digits 。你可以用任意次数 digits[i] 来写的数字。
 * 例如，如果 digits = ['1','3','5']，我们可以写数字，如 '13', '551', 和 '1351315'。
 * <p>
 * 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。
 * <p>
 * 示例 1：
 * 输入：digits = ["1","3","5","7"], n = 100
 * 输出：20
 * 解释：
 * 可写出的 20 个数字是：
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * <p>
 * 示例 2：
 * 输入：digits = ["1","4","9"], n = 1000000000
 * 输出：29523
 * 解释：
 * 我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
 * 81 个四位数字，243 个五位数字，729 个六位数字，
 * 2187 个七位数字，6561 个八位数字和 19683 个九位数字。
 * 总共，可以使用D中的数字写出 29523 个整数。
 * <p>
 * 示例 3:
 * 输入：digits = ["7"], n = 8
 * 输出：1
 * <p>
 * 提示：
 * 1 <= digits.length <= 9
 * digits[i].length == 1
 * digits[i] 是从 '1' 到 '9' 的数
 * digits 中的所有值都 不同
 * digits 按 非递减顺序 排列
 * 1 <= n <= 10^9
 * <p>
 * https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/
 */
public class Problem902_numbersAtMostNGivenDigitSet {

    // Backtrack time: O(n) space: O(n)
    // TLE
    public static int atMostNGivenDigitSet(String[] digits, int n) {
        if (digits == null || digits.length == 0) {
            return 0;
        }

        List<Integer> nums = new ArrayList<>();
        int maxLen = Math.min(String.valueOf(n).length() + 1, 10);
        for (int i = 1; i <= maxLen; i++) {
            backtrack(nums, new StringBuilder(), digits, 0, i, n);
        }

        return nums.size();
    }

    private static void backtrack(List<Integer> res, StringBuilder path, String[] digits, int start, int maxLen, int max) {
        if (path.length() == maxLen) {
            long num = Long.parseLong(path.toString());
            if (num <= max) {
                res.add((int) num);
            }

            return;
        }

        for (int i = 0; i < digits.length; i++) {
            path.append(digits[i]);
            backtrack(res, path, digits, i + 1, maxLen, max);
            path.deleteCharAt(path.length() - 1);
        }
    }

    // Backtrack Opt
    // TLE
    public static int atMostNGivenDigitSet_bt(String[] digits, int n) {
        if (digits == null || digits.length == 0) {
            return 0;
        }

        int len = digits.length;

        List<Integer> nums = new ArrayList<>();
        int maxLen = Math.min(String.valueOf(n).length(), 10);
        backtrack(nums, new StringBuilder(), digits, 0, maxLen, n);

        int ans = nums.size();
        for (int i = 1; i < maxLen; i++) {
            ans += Math.pow(len, i);
        }

        return ans;
    }


    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
//        System.out.println(Integer.parseInt("4111111111"));
        System.out.println("1 ?= " + atMostNGivenDigitSet(new String[]{"7"}, 8));
        System.out.println("2 ?= " + atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));
        System.out.println("20 ?= " + atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println("29523 ?= " + atMostNGivenDigitSet(new String[]{"1", "4", "9"}, 1000000000));

        System.out.println("20 ?= " + atMostNGivenDigitSet_bt(new String[]{"1", "3", "5", "7"}, 100));
        System.out.println("29523 ?= " + atMostNGivenDigitSet_bt(new String[]{"1", "4", "9"}, 1000000000));
    }
}
