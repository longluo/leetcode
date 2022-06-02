package com.longluo.contest.weekly_contest_292;

/**
 * 2264. 字符串中最大的 3 位相同数字
 * <p>
 * 给你一个字符串 num ，表示一个大整数。如果一个整数满足下述所有条件，则认为该整数是一个 优质整数 ：
 * <p>
 * 该整数是 num 的一个长度为 3 的 子字符串 。
 * 该整数由唯一一个数字重复 3 次组成。
 * 以字符串形式返回 最大的优质整数 。如果不存在满足要求的整数，则返回一个空字符串 "" 。
 * <p>
 * 注意：
 * 子字符串 是字符串中的一个连续字符序列。
 * num 或优质整数中可能存在 前导零 。
 * <p>
 * 示例 1：
 * 输入：num = "6777133339"
 * 输出："777"
 * 解释：num 中存在两个优质整数："777" 和 "333" 。
 * "777" 是最大的那个，所以返回 "777" 。
 * <p>
 * 示例 2：
 * 输入：num = "2300019"
 * 输出："000"
 * 解释："000" 是唯一一个优质整数。
 * <p>
 * 示例 3：
 * 输入：num = "42352338"
 * 输出：""
 * 解释：不存在长度为 3 且仅由一个唯一数字组成的整数。因此，不存在优质整数。
 * <p>
 * 提示：
 * 3 <= num.length <= 1000
 * num 仅由数字（0 - 9）组成
 * <p>
 * https://leetcode.cn/problems/largest-3-same-digit-number-in-string/
 */
public class Problem2264_largestGoodInteger {

    // TODO: 2022/6/2
    public static String largestGoodInteger(String num) {
        int len = num.length();
        int cnt = 1;
        int max = -1;
        for (int i = 1; i < len; i++) {
            char ch = num.charAt(i);
            if (ch != num.charAt(i - 1)) {
                cnt = 1;
            } else {
                cnt++;
                if (cnt == 3) {
                    max = Math.max(max, ch - '0');
                    cnt = 0;
                }
            }
        }

        return max > -1 ? "" + max + max + max : "";
    }

    public static String largestGoodInteger_fast(String num) {
        for (int i = 9; i >= 0; i--) {
            String str = String.valueOf(i).repeat(3);
            if (num.contains(str)) {
                return str;
            }
        }

        return "";
    }

    public static void main(String[] args) {
        System.out.println(largestGoodInteger("2300019"));
        System.out.println(largestGoodInteger("000"));
        System.out.println(largestGoodInteger("42352338"));
        System.out.println(largestGoodInteger("6777133339"));
    }
}
